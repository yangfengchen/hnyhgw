/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.service;

import com.hnyhgw.entity.CodeItemEntity;

import java.util.List;
import java.util.Map;

public interface CodeItemService extends AbstractBaseService<CodeItemEntity,String>{

    //菜单类型
    public static final String MENU_TYPE = "menu-type";

    Map<String,String> findByTypeToMap(String type);
}
