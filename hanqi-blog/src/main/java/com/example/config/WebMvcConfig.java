package com.example.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 集成 redis 之后可以使用的地方又很多，比如我们的侧边栏热议功能，还有我们的缓存注解 Cacheable 等。
 * 但是使用了 redis 的缓存注解，你会发现不能给注解设定一个缓存过期时间，为了解决这个问题，我们引入 redission。
 */
@EnableCaching
@Configuration
public class WebMvcConfig {
}

/**
 * 引入了 jar 包之后，我们就可以使用 redission 功能了，
 * 比如做分布式锁、给缓存注解一个过期时间等 ok、关于 redis 模块就说到这里，下面我们去填充一下首页的数据先。
 */
