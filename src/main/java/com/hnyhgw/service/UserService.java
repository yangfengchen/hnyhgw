package com.hnyhgw.service;

import com.hnyhgw.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService extends AbstractBaseService<UserEntity,String> {

    /**
     * 方法实现说明
     * @param name
     * @param pwd
     * @param request
     * @return      java.util.Map<java.lang.String,java.lang.Object>
     * @exception
     */
    Map<String,Object> loginUser(String name, String pwd, HttpServletRequest request);
}
