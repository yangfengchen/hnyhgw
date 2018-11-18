package com.hnyhgw.controller;

import com.hnyhgw.service.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="test")
public class TestController {
    @Autowired
    private ArticleContentService articleContentService;

    @RequestMapping(value="/index")
    @ResponseBody
    public String index(){
        return "";
    }
}
