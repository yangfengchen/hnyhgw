package com.hnyhgw.service.impl;

import com.google.common.collect.Maps;
import com.hnyhgw.common.AjaxResultStatus;
import com.hnyhgw.common.KeysCommon;
import com.hnyhgw.dto.CommonRequestParamDto;
import com.hnyhgw.entity.UserEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.UserRepository;
import com.hnyhgw.service.UserService;
import com.hnyhgw.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<UserEntity,String> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AbstractBaseRepository<UserEntity, String> getAbstractBaseRepository() {
        return userRepository;
    }

    @Override
    public Map<String, Object> loginUser(String name, String pwd, HttpServletRequest request) {
        Map<String,Object> rs = Maps.newHashMap();
        UserEntity userEntity = userRepository.findByName(name);
        if(userEntity == null){
            rs.put(AjaxResultStatus.STATUS_STR,AjaxResultStatus.ERROR_CODE);
            rs.put(AjaxResultStatus.MESSAGE_STR,"用户不存在！");
            return rs;
        }
        if(!StringUtils.equals(MD5Utils.getMD5String(pwd),userEntity.getPwd())){
            rs.put(AjaxResultStatus.STATUS_STR,AjaxResultStatus.ERROR_CODE);
            rs.put(AjaxResultStatus.MESSAGE_STR,"密码不正确！");
            return rs;
        }
        rs.put(AjaxResultStatus.STATUS_STR,AjaxResultStatus.SUCCESS_CODE);
        request.getSession().setAttribute(KeysCommon.MANAGE_USER_KEY,userEntity);
        return rs;
    }

    @Override
    public Page<UserEntity> findByPage(CommonRequestParamDto requestParamDto) {
        return null;
    }
}
