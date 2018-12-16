/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.controller;
import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.common.ManagePathCommon;
import com.hnyhgw.dto.ArticleTypeSearchDto;
import com.hnyhgw.entity.MenuBarEntity;
import com.hnyhgw.service.CodeItemService;
import com.hnyhgw.service.MenuBarService;
import com.hnyhgw.util.IdUtils;
import com.hnyhgw.util.JacksonUtils;
import com.hnyhgw.vo.AjaxResultVo;
import com.hnyhgw.vo.MenuBarVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "manage/menuBar")
public class ManageMenuBarController extends AbstractBaseController{

    @Autowired
    private MenuBarService menuBarService;

    @Autowired
    private CodeItemService codeItemService;

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        getMenuType(request);
        return ManagePathCommon.COMMON_START_URL + "menuBar/index";
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestBody ArticleTypeSearchDto articleTypeSearchDto, HttpServletRequest request){
        List<MenuBarVo> menuBarVos = menuBarService.findByEnableToTreeTable();
        return JacksonUtils.object2Json(menuBarVos);
    }

    @RequestMapping("create")
    public String create(HttpServletRequest request){
        getMenuType(request);
        getMenuBarAll(request);
        MenuBarEntity menuBarEntity = new MenuBarEntity();
        menuBarEntity.setParentId("0");
        menuBarEntity.setEnable(true);
        menuBarEntity.setSort(1);
        request.setAttribute("entity",menuBarEntity);
        return ManagePathCommon.COMMON_START_URL + "menuBar/edit";
    }

    @RequestMapping("edit")
    public String edit(@RequestParam("id")String id, HttpServletRequest request){
        String message = request.getParameter("message");
        if(StringUtils.isNotBlank(message)){
            request.setAttribute("message",message);
        }
        getMenuType(request);
        getMenuBarAll(request);
        MenuBarEntity menuBarEntity = menuBarService.findById(id);
        request.setAttribute("entity",menuBarEntity);
        return ManagePathCommon.COMMON_START_URL + "menuBar/edit";
    }

    @RequestMapping("addChilder")
    public String addChilder(@RequestParam("id")String id, HttpServletRequest request){
        getMenuType(request);
        getMenuBarAll(request);
        MenuBarEntity parentMenuBarEntity = menuBarService.findByParentId(id);
        MenuBarEntity menuBarEntity = new MenuBarEntity();
        menuBarEntity.setParentId(parentMenuBarEntity.getId());
        menuBarEntity.setEnable(true);
        menuBarEntity.setSort(1);
        request.setAttribute("entity",menuBarEntity);
        return ManagePathCommon.COMMON_START_URL + "menuBar/edit";
    }

    @RequestMapping("save")
    public String save(MenuBarEntity entity, RedirectAttributes redirectAttributes){
        boolean isUpdate = true;
        if(StringUtils.isBlank(entity.getId())){
            isUpdate = false;
            entity.setId(IdUtils.getSnowflakeIdWorkerId());
        }
        if(StringUtils.equals(entity.getParentId(),"0")){
            entity.setChilderId(entity.getParentId()+","+entity.getId());
        }else{
            MenuBarEntity parentMenuBarEntity = menuBarService.findByParentId(entity.getParentId());
            entity.setChilderId(parentMenuBarEntity.getChilderId()+","+entity.getId());
        }
        menuBarService.save(entity);
        if(isUpdate){
            List<MenuBarEntity> childers = menuBarService.findChilderByParentId(entity.getId());
            if(CollectionUtils.isNotEmpty(childers)){
                for(MenuBarEntity menuBarEntity : childers){
                    menuBarEntity.setChilderId(entity.getChilderId() + "," + menuBarEntity.getId());
                }
                menuBarService.saveAll(childers);
            }
        }

        redirectAttributes.addAttribute("message","操作成功");
        return REDIRECT + ManagePathCommon.COMMON_START_URL + "menuBar/edit?id=" + entity.getId();
    }

    @RequestMapping("delete")
    @ResponseBody
    public AjaxResultVo delete(@RequestParam("id")String id,
                               @RequestParam("tableName")String tableName,
                               RedirectAttributes redirectAttributes){
        if(StringUtils.isNotBlank(id)){
            menuBarService.deleteById(id);
            menuBarService.deleteByParentId(id);
            return AjaxResultVo.builder()
                    .status(AjaxResultStatus.SUCCESS_CODE)
                    .data(tableName)
                    .build();
        }
        return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).build();
    }

    private void getMenuType(HttpServletRequest request){
        Map<String,String> maps = codeItemService.findByTypeToMap(CodeItemService.MENU_TYPE);
        request.setAttribute("menuTypesObj",maps);
        request.setAttribute("menuTypes",JacksonUtils.object2Json(maps));
    }

    private void getMenuBarAll(HttpServletRequest request){
        List<MenuBarEntity> menuBarEntities = menuBarService.findByEnable();
        request.setAttribute("menuBars",menuBarEntities);
    }
}
