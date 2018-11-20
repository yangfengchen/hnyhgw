package com.hnyhgw.controller;

import com.hnyhgw.service.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="test")
public class TestControllerAbstract extends AbstractBaseController {
    @Autowired
    private ArticleContentService articleContentService;

    @RequestMapping(value="index")
    public String index(){
        return "test/index";
    }

    @RequestMapping(value="save")
    public String save(HttpServletRequest request, Model model){
        System.out.println(request.getParameter("content"));
        System.out.println(request.getParameter("name")+"namekx");
        return "test/home";
    }
}
