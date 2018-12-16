package com.hnyhgw.controller;


import com.google.common.collect.Lists;
import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.common.ManagePathCommon;
import com.hnyhgw.dto.ArticleTypeSearchDto;
import com.hnyhgw.dto.CommonResponseDto;
import com.hnyhgw.entity.ArticleTypeEntity;
import com.hnyhgw.service.ArticleTypeService;
import com.hnyhgw.util.IdUtils;
import com.hnyhgw.vo.AjaxResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "manage/articleType")
public class ManageArticleTypeController extends AbstractBaseController{

    @Autowired
    private ArticleTypeService articleTypeService;

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        return ManagePathCommon.COMMON_START_URL + "articleType/index";
    }

    @RequestMapping("list")
    @ResponseBody
    public CommonResponseDto list(@RequestBody ArticleTypeSearchDto articleTypeSearchDto, HttpServletRequest request){
        Page<ArticleTypeEntity> pages = articleTypeService.findByPage(articleTypeSearchDto);
        return CommonResponseDto.builder().total(pages.getTotalElements()).rows(pages.getContent()).build();
    }

    @RequestMapping("create")
    public String create(HttpServletRequest request){
        ArticleTypeEntity articleTypeEntity = new ArticleTypeEntity();
        articleTypeEntity.setSort(1);
        articleTypeEntity.setEnable(true);
        request.setAttribute("entity",articleTypeEntity);
        return ManagePathCommon.COMMON_START_URL + "articleType/edit";
    }

    @RequestMapping("edit")
    public String edit(@RequestParam("id")String id,HttpServletRequest request){
        String message = request.getParameter("message");
        if(StringUtils.isNotBlank(message)){
            request.setAttribute("message",message);
        }
        ArticleTypeEntity articleTypeEntity = articleTypeService.findById(id);
        request.setAttribute("entity",articleTypeEntity);
        return ManagePathCommon.COMMON_START_URL + "articleType/edit";
    }

    @RequestMapping("save")
    public String save(ArticleTypeEntity entity, RedirectAttributes redirectAttributes){
        if(StringUtils.isBlank(entity.getId())){
            entity.setId(IdUtils.getSnowflakeIdWorkerId());
        }
        articleTypeService.save(entity);
        redirectAttributes.addAttribute("message","操作成功");
        return REDIRECT + ManagePathCommon.COMMON_START_URL + "articleType/edit?id=" + entity.getId();
    }

    @RequestMapping("baseView")
    public String view(@RequestParam("id")String id, HttpServletRequest request){
        ArticleTypeEntity articleTypeEntity = articleTypeService.findById(id);
        request.setAttribute("entity",articleTypeEntity);
        return ManagePathCommon.COMMON_START_URL + "articleType/baseView";
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResultVo delete(@RequestParam("id")String id,
                               @RequestParam("tableName")String tableName,
                               RedirectAttributes redirectAttributes){
        if(StringUtils.isNotBlank(id)){
            articleTypeService.deleteById(id);
            return AjaxResultVo.builder()
                    .status(AjaxResultStatus.SUCCESS_CODE)
                    .data(tableName)
                    .build();
        }
        return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).build();
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
