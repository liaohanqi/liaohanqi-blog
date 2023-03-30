package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Post;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 廖汉奇
 * @since 2023-03-29
 */
public interface PostService extends IService<Post> {

    public void initWeekRank();

}
