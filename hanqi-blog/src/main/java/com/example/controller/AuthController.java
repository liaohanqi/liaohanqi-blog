package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @RequestMapping("/login")
    public String login(){
        return "auth/login";
    }

//    register
    @RequestMapping("/reg")
    public String register(){
        return "auth/reg";
    }

}
