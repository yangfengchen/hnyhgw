/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.controller;

import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.service.CodeItemService;
import com.hnyhgw.vo.AjaxResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("codeItem")
public class CodeItemController {

    @Autowired
    private CodeItemService codeItemService;

    @RequestMapping("findByTypeToMap")
    @ResponseBody
    public AjaxResultVo findByTypeToMap(@RequestParam("type")String type){
        return AjaxResultVo.builder()
                .status(AjaxResultStatus.SUCCESS_CODE)
                .data(codeItemService.findByTypeToMap(type))
                .build();
    }
}
