package com.hnyhgw.controller;

import com.google.common.collect.Lists;
import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.dto.ArticleContentSearchDto;
import com.hnyhgw.dto.CommonResponseDto;
import com.hnyhgw.entity.ArticleContentEntity;
import com.hnyhgw.service.ArticleContentService;
import com.hnyhgw.service.ArticleTypeService;
import com.hnyhgw.service.MenuBarService;
import com.hnyhgw.vo.AjaxResultVo;
import com.hnyhgw.vo.MenuBarTreeVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PortalIndexController extends AbstractBaseController{

    @Autowired
    private MenuBarService menuBarService;
    @Autowired
    private ArticleContentService articleContentService;
    @Autowired
    private ArticleTypeService articleTypeService;


    @RequestMapping("/")
    public String index(HttpServletRequest request){
        List<MenuBarTreeVo> menuBarVos = menuBarService.findByEnableToTree();
        request.setAttribute("menuBarVos",menuBarVos);
        return "index";
    }

    @RequestMapping("contentList")
    public String contentList(@RequestParam("type")String type, HttpServletRequest request){
        if(StringUtils.isNotBlank(type)){
            request.setAttribute("type",type);
            return "contentList";
        }
        return "error/404";
    }

    @RequestMapping("contentRest")
    @ResponseBody
    public CommonResponseDto contentList(@RequestBody ArticleContentSearchDto articleContentSearchDto, HttpServletRequest request){
        if(StringUtils.isBlank(articleContentSearchDto.getArticleTypeId())){
            return CommonResponseDto.builder().total(0L).rows(Lists.newArrayList()).build();
        }
        Page<ArticleContentEntity> pages = articleContentService.findByPage(articleContentSearchDto);
        if(CollectionUtils.isNotEmpty(pages.getContent())){
            pages.getContent().parallelStream().forEach((ArticleContentEntity entity) ->{
                entity.setContent("");
            });
        }
        return CommonResponseDto.builder().total(pages.getTotalElements()).rows(pages.getContent()).build();
    }

    @RequestMapping("contentInfo")
    public String contentInfo(@RequestParam("id")String id, HttpServletRequest request){
        if(StringUtils.isBlank(id)){
            return "error/404";
        }
        ArticleContentEntity articleContentEntity = articleContentService.findById(id);
        if(articleContentEntity == null){
            return "error/404";
        }
        request.setAttribute("entity",articleContentEntity);
        return "contentInfo";
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public AjaxResultVo selectAll(HttpServletRequest request){
        return AjaxResultVo.builder()
                .status(AjaxResultStatus.SUCCESS_CODE)
                .data(articleTypeService.findSelectArticleTypeToMap(request.getParameter("name")))
                .build();
    }
}
