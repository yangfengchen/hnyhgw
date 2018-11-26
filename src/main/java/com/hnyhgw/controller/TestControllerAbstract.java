package com.hnyhgw.controller;

import com.google.common.collect.Lists;
import com.hnyhgw.entity.ArticleContentEntity;
import com.hnyhgw.service.ArticleContentService;
import com.hnyhgw.vo.MyTree;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(value="tree")
    public String tree(Model model){
        ArticleContentEntity articleContentEntity = new ArticleContentEntity();
        articleContentEntity.setId("123");
        articleContentEntity.setTitleName("测试");
        return "test/tree";
    }

    @RequestMapping(value="saveTree", method = RequestMethod.POST)
    public String saveTree(MyTree myTree){
        System.out.println(myTree.getId());
        return "test/tree";
    }
}
