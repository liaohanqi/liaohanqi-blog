package com.example.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private String code;
    private String msg;
    private Object data;

    public static Result succ(Object data){
        Result result = new Result();
        result.setCode("0");
        result.setData(data);
        result.setMsg("操作成功");
        return result;
    }

    public static Result succ(String mess,Object data){
        Result result = new Result();
        result.setCode("0");
        result.setData(data);
        result.setMsg(mess);
        return result;
    }

    public static Result fail(String mess){
        Result result = new Result();
        result.setCode("-1");
        result.setData(null);
        result.setMsg(mess);
        return result;
    }

    public static Result fail(String mess,Object data){
        Result result = new Result();
        result.setCode("-1");
        result.setData(data);
        result.setMsg(mess);
        return result;
    }

}
