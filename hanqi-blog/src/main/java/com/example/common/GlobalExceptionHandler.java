package com.example.common;

import com.example.common.lang.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defauleErrorHandler(HttpServletRequest req, Exception e){

        if(e instanceof  HwException){
            //....
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("message",e.getMessage());
        mav.addObject("url",req.getRequestURL());
        mav.setViewName("error");
        return mav;

    }

    @ExceptionHandler(value = HwException.class)
    public Result jsonErrorHandler(HttpServletRequest req, HwException e){
        return Result.fail(e.getMessage(),"some error data");
    }

}
