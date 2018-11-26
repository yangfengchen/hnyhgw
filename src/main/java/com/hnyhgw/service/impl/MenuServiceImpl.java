package com.hnyhgw.service.impl;

import com.hnyhgw.entity.MenuEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.MenuRepository;
import com.hnyhgw.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends AbstractBaseServiceImpl<MenuEntity,String> implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public AbstractBaseRepository<MenuEntity, String> getAbstractBaseRepository() {
        return menuRepository;
    }
}
