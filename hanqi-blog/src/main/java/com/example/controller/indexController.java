package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController extends BaseController{

    @RequestMapping({"","/","index"})
    public String index(){
        return "index";
    }

}
