package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 廖汉奇
 * @since 2023-03-29
 */
@Controller
public class PostController {

//    \d 指定这个参数的类型，数据类型
    @GetMapping("/category/{id:\\d}")
    public String category(@PathVariable(name = "id")Long id){
        return "post/category";
    }

    @GetMapping("/post/{id:\\d}")
    public String detail(@PathVariable(name = "id")Long id){
        return "post/detail";
    }

}
