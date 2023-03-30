package com.example.common;

public class HwException extends RuntimeException{

    private int code;

    /**
     * 构造器作为一种方法，负责类中成员变量（域）的初始化。实例构造器分为缺省构造器和非缺省构造器。
     *
     *
     * 构造器最大的用处就是在创建对象时执行初始化，当创建一个对象时，系统会为这个对象的实例进行默认的初始化。如果想改变这种默认的初始化，就可以通过自定义构造器来实现。
     * 构造器是为了创建一个类的实例化对象的时候用到：InstanceObject IO = new InstanceObject(); 构造器可以用来在初始化对象时，初始化数据成员，即包括初始化属性和方法。
     * 一个类可以有多个构造器。一个类的构造器的名称必须与该类的名称一致。要退出构造，可以使用返回语句“return;”。
     */
    public HwException(){}

    public HwException(int code){
        this.code = code;
    }

    public HwException(String message){
        super(message);
    }

    public HwException(int code,String message){
        super(message);
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

}
