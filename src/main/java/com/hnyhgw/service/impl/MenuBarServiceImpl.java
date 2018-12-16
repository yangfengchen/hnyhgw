/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hnyhgw.dto.CommonRequestParamDto;
import com.hnyhgw.entity.MenuBarEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.MenuBarRepository;
import com.hnyhgw.service.MenuBarService;
import com.hnyhgw.util.BeanCopyUtils;
import com.hnyhgw.vo.MenuBarTreeVo;
import com.hnyhgw.vo.MenuBarVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MenuBarServiceImpl extends AbstractBaseServiceImpl<MenuBarEntity,String> implements MenuBarService {

    @Autowired
    private MenuBarRepository menuBarRepository;

    @Override
    public AbstractBaseRepository<MenuBarEntity, String> getAbstractBaseRepository() {
        return menuBarRepository;
    }

    @Override
    public Page<MenuBarEntity> findByPage(CommonRequestParamDto requestParamDto) {
        return null;
    }

    @Override
    public List<MenuBarEntity> findByEnable() {
        return menuBarRepository.findByEnable();
    }

    @Override
    public List<MenuBarVo> findByEnableToTreeTable() {
        List<MenuBarVo> menuBarVos = Lists.newArrayList();
        List<MenuBarEntity> lists = findByEnable();
        Map<String,Long> ids = Maps.newHashMap();
        if(CollectionUtils.isNotEmpty(lists)){
            int size = lists.size();
            for(int i = 0 ; i < size ; i++){
                MenuBarVo menuBarVo = new MenuBarVo();
                BeanCopyUtils.copyProperties(lists.get(i),menuBarVo);
                menuBarVo.setId(Long.valueOf(i+1));
                menuBarVo.setEntityId(lists.get(i).getId());
                menuBarVo.setEntityParentId(lists.get(i).getParentId());
                if(StringUtils.equals(menuBarVo.getEntityParentId(),"0")){
                    menuBarVo.setParentId(Long.valueOf(0));
                }else{
                    menuBarVo.setParentId(Long.valueOf(9999));
                }
                ids.put(menuBarVo.getEntityId(),menuBarVo.getId());
                menuBarVos.add(menuBarVo);
            }
        }
        //重新设置parentId值
        if(CollectionUtils.isNotEmpty(menuBarVos)){
            menuBarVos.parallelStream().forEach((MenuBarVo entity) ->{
                if(entity.getParentId()==9999){
                    entity.setParentId(ids.get(entity.getEntityParentId()));
                }
            });
        }
        return menuBarVos;
    }

    @Override
    public MenuBarEntity findByParentId(String parentId) {
        return menuBarRepository.findByParentId(parentId);
    }

    @Override
    public List<MenuBarEntity> findChilderByParentId(String parentId) {
        return menuBarRepository.findChilderByParentId(parentId);
    }

    @Override
    public void deleteByParentId(String parentId) {
        menuBarRepository.deleteByParentId(parentId);
    }

    @Override
    public List<MenuBarTreeVo> findByEnableToTree() {
        List<MenuBarEntity> menuBarEntities = findByEnable();
        List<MenuBarTreeVo> parentMenu = getParentMenu(menuBarEntities);
        if(CollectionUtils.isNotEmpty(parentMenu)){
            for(MenuBarTreeVo menuBarTreeVo : parentMenu){
                menuBarTreeVo.setDatas(getChilder(menuBarTreeVo,menuBarEntities));
            }
        }
        return parentMenu;
    }

    private List<MenuBarTreeVo> getChilder(MenuBarTreeVo parentMenu,List<MenuBarEntity> menuBarEntities){
        List<MenuBarTreeVo> childers = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(menuBarEntities)){
            for(MenuBarEntity menuBarEntity : menuBarEntities){
                if(StringUtils.equals(parentMenu.getId(),menuBarEntity.getParentId())){
                    MenuBarTreeVo menuBarTreeVo = new MenuBarTreeVo();
                    BeanCopyUtils.copyProperties(menuBarEntity,menuBarTreeVo);
                    menuBarTreeVo.setDatas(getChilder(menuBarTreeVo,menuBarEntities));
                    childers.add(menuBarTreeVo);
                }
            }
        }
        return childers;
    }

    private List<MenuBarTreeVo> getParentMenu(List<MenuBarEntity> menuBarEntities){
        List<MenuBarTreeVo> parentMenu = Lists.newArrayList();
        List<MenuBarEntity> remvoeObj = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(menuBarEntities)){
            menuBarEntities.stream().forEach((MenuBarEntity entity)->{
                if(StringUtils.equals(entity.getParentId(),"0")){
                    MenuBarTreeVo menuBarTreeVo = new MenuBarTreeVo();
                    BeanCopyUtils.copyProperties(entity,menuBarTreeVo);
                    parentMenu.add(menuBarTreeVo);
                    remvoeObj.add(entity);
                }
            });
        }
        menuBarEntities.removeAll(remvoeObj);
        return parentMenu;
    }


}
