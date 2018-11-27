package com.hnyhgw;

public class TestSplit {
    public static void main(String[] args) {
        String url = "http://loalhost:8080/manage";
        url = url.substring(url.indexOf("/manage")+7,url.length());
        System.out.println(url.length());
    }
}
