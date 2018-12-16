/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.controller;

import com.hnyhgw.common.ManagePathCommon;
import com.hnyhgw.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "manage")
public class ManageIndexController extends AbstractBaseController{


    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "initMenu")
    private String initMenu(HttpServletRequest request){
        request.setAttribute("menuVoAll",menuService.findMenuVoByAll());
        return ManagePathCommon.COMMON_START_URL + "menu";
    }
}
