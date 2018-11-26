package com.hnyhgw.service.impl;

import com.hnyhgw.entity.UserEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.UserRepository;
import com.hnyhgw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractBaseServiceImpl<UserEntity,String> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AbstractBaseRepository<UserEntity, String> getAbstractBaseRepository() {
        return userRepository;
    }
}
