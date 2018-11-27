package com.hnyhgw.util;

public class DateUtils {

    public static double getDataToDouble(){
        return Double.valueOf(Long.toString(System.currentTimeMillis()));
    }
}
