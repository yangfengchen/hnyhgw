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
import com.hnyhgw.entity.CodeItemEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.CodeItemRepository;
import com.hnyhgw.service.CodeItemService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CodeItemServiceImpl extends AbstractBaseServiceImpl<CodeItemEntity,String> implements CodeItemService {

    @Autowired
    private CodeItemRepository codeItemRepository;

    @Override
    public AbstractBaseRepository<CodeItemEntity, String> getAbstractBaseRepository() {
        return codeItemRepository;
    }

    @Override
    public Page<CodeItemEntity> findByPage(CommonRequestParamDto requestParamDto) {
        return null;
    }


    @Override
    public Map<String, String> findByTypeToMap(String type) {
        List<CodeItemEntity> codeItemEntities = codeItemRepository.findByType(type);
        Map<String,String> data = Maps.newHashMap();
        if(CollectionUtils.isNotEmpty(codeItemEntities)){
            for(CodeItemEntity codeItemEntity : codeItemEntities){
                data.put(codeItemEntity.getValue(),codeItemEntity.getName());
            }
        }
        return data;
    }
}
