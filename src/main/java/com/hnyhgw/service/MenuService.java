package com.hnyhgw.service;

import com.hnyhgw.entity.MenuEntity;
import com.hnyhgw.vo.MenuVo;

import java.util.List;

public interface MenuService extends AbstractBaseService<MenuEntity,String>{

    /**
     * 查询所有菜单列表
     * @return
     * @exception
     */
    List<MenuVo> findMenuVoByAll();
}
