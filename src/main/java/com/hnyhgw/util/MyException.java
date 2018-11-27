package com.hnyhgw.util;

public class MyException extends RuntimeException{

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;
}
