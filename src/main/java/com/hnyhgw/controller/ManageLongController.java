package com.hnyhgw.controller;

import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.common.ManagePathCommon;
import com.hnyhgw.service.UserService;
import com.hnyhgw.vo.AjaxResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping(value="manage")
public class ManageLongController extends AbstractBaseController{



    @Autowired
    private UserService userService;

    @RequestMapping(value="login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        return ManagePathCommon.COMMON_START_URL + "login";
    }

    @RequestMapping(value = "ajaxLogin",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResultVo ajaxLogin(String name,String pwd,HttpServletRequest request){
        if(StringUtils.isBlank(name) || StringUtils.isBlank(pwd)){
            return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).message("用户名或者密码不能为空").build();
        }
        Map<String,Object> rs = userService.loginUser(name,pwd,request);
        if(rs.get(AjaxResultStatus.STATUS_STR) != null){
            if(StringUtils.equals(rs.get(AjaxResultStatus.STATUS_STR).toString(),AjaxResultStatus.SUCCESS_CODE)){
                return AjaxResultVo.builder().status(AjaxResultStatus.SUCCESS_CODE).message("登入成功").build();
            }else{
                return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).message(rs.get(AjaxResultStatus.MESSAGE_STR).toString()).build();
            }
        }
        return AjaxResultVo.builder().status(AjaxResultStatus.ERROR_CODE).message("用户名或者密码不能为空").build();
    }

    @RequestMapping(value = "index")
    public String index(Model model){
        return ManagePathCommon.COMMON_START_URL+"index";
    }

}
