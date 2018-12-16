package com.hnyhgw.controller;


import com.google.common.collect.Lists;
import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.common.ManagePathCommon;
import com.hnyhgw.dto.ArticleContentSearchDto;
import com.hnyhgw.dto.CommonResponseDto;
import com.hnyhgw.entity.ArticleContentEntity;
import com.hnyhgw.service.ArticleContentService;
import com.hnyhgw.util.IdUtils;
import com.hnyhgw.vo.AjaxResultVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "manage/articleContent")
public class ManageArticleContentController extends AbstractBaseController{

    @Autowired
    private ArticleContentService articleContentService;

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        return ManagePathCommon.COMMON_START_URL + "articleContent/index";
    }

    @RequestMapping("list")
    @ResponseBody
    public CommonResponseDto list(@RequestBody ArticleContentSearchDto articleContentSearchDto, HttpServletRequest request){
        Page<ArticleContentEntity> pages = articleContentService.findByPage(articleContentSearchDto);
        if(CollectionUtils.isNotEmpty(pages.getContent())){
            pages.getContent().parallelStream().forEach((ArticleContentEntity entity) ->{
                entity.setContent("");
            });
        }
        return CommonResponseDto.builder().total(pages.getTotalElements()).rows(pages.getContent()).build();
    }

    @RequestMapping("create")
    public String create(HttpServletRequest request){
        ArticleContentEntity articleContentEntity = new ArticleContentEntity();
        articleContentEntity.setSort(1);
        articleContentEntity.setEnable(true);
        articleContentEntity.setPublishDate(new Date());
        request.setAttribute("entity",articleContentEntity);
        return ManagePathCommon.COMMON_START_URL + "articleContent/edit";
    }

    @RequestMapping("edit")
    public String edit(@RequestParam("id")String id, HttpServletRequest request){
        String message = request.getParameter("message");
        if(StringUtils.isNotBlank(message)){
            request.setAttribute("message",message);
        }
        ArticleContentEntity articleContentEntity = articleContentService.findById(id);
        request.setAttribute("entity",articleContentEntity);
        return ManagePathCommon.COMMON_START_URL + "articleContent/edit";
    }

    @RequestMapping("save")
    public String save(ArticleContentEntity entity, RedirectAttributes redirectAttributes){
        if(StringUtils.isBlank(entity.getId())){
            entity.setId(IdUtils.getSnowflakeIdWorkerId());
        }
        articleContentService.save(entity);
        redirectAttributes.addAttribute("message","操作成功");
        return REDIRECT + ManagePathCommon.COMMON_START_URL + "articleContent/edit?id=" + entity.getId();
    }

    @RequestMapping("baseView")
    public String view(@RequestParam("id")String id, HttpServletRequest request){
        ArticleContentEntity ArticleContentEntity = articleContentService.findById(id);
        request.setAttribute("entity",ArticleContentEntity);
        return ManagePathCommon.COMMON_START_URL + "articleContent/baseView";
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResultVo delete(@RequestParam("id")String id,
                               @RequestParam("tableName")String tableName,
                               RedirectAttributes redirectAttributes){
        if(StringUtils.isNotBlank(id)){
            articleContentService.deleteById(id);
            return AjaxResultVo.builder()
                    .status(AjaxResultStatus.SUCCESS_CODE)
                    .data(tableName)
                    .build();
        }
        return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).build();
    }

}
