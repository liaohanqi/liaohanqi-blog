package com.example.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Post;
import com.example.mapper.PostMapper;
import com.example.service.PostService;
import com.example.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 廖汉奇
 * @since 2023-03-29
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    RedisUtil redisUtil;

    /**
     * 本周热议初始化
     */
    @Override
    public void initWeekRank() {

        //获取7天的发表的文章
        //从数据库获取评论的数据，然后放进redis中
        List<Post> posts = this.list(new QueryWrapper<Post>()
            .ge("created", DateUtil.offsetDay(new Date(),-7))
            .select("id, title, user_id, comment_count, view_count, created")
        );

        //初始化文章的总评论量
        for (Post post : posts) {

            String key = "day:rank:" + DateUtil.format(post.getCreated(), DatePattern.PURE_DATE_FORMAT);

            //放进的是zset里
            redisUtil.zSet(key,post.getId(),post.getCommentCount());

            //7天后自动过期
            long between = DateUtil.between(new Date(), post.getCreated(), DateUnit.DAY);
            long expireTime = (7 - between) * 24 * 60 * 60;

            redisUtil.expire(key,expireTime);

            //缓存文章的一些基本信息（id,标题，评论数量，作者）
            this.hashCachePostIdAndTitle(post,expireTime);

        }
        //做并集
        this.zunionAndStoreLast7DayForWeekRank();

        //aaaa
    }

    /**
     * 缓存文章的基本信息
     * @param post
     * @param expireTime
     */
    private void hashCachePostIdAndTitle(Post post, long expireTime) {
        String key = "rank:post:" + post.getId();

        //存进的是hash结构里，与上面不同
        boolean hasKey = redisUtil.hasKey(key);
        if (!hasKey){
            redisUtil.hset(key,"post:id",post.getId(),expireTime);
            redisUtil.hset(key,"post:title",post.getTitle(),expireTime);
            redisUtil.hset(key,"post:commentCount",post.getCommentCount(),expireTime);
            redisUtil.hset(key,"post:viewCount",post.getViewCount(),expireTime);
        }
    }

    /**
     * 本周合并每日评论数量操作
     */
    private void zunionAndStoreLast7DayForWeekRank() {
        String currentKey = "day:rank:" + DateUtil.format(new Date(), DatePattern.PURE_DATE_FORMAT);

        String destKey = "week:rank";
        List<String> otheyKeys = new ArrayList<>();
        for (int i = -6; i < 0; i++) {
            String temp = "day:rank:" + DateUtil.format(DateUtil.offsetDay(new Date(), i), DatePattern.PURE_DATE_FORMAT);

            otheyKeys.add(temp);
        }

        //在zset集合里进行合集找出本周7天热议
        redisUtil.zUnionAndStore(currentKey,otheyKeys,destKey);
    }
}
