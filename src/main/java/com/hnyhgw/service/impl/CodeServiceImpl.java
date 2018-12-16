/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.service.impl;

import com.hnyhgw.dto.CommonRequestParamDto;
import com.hnyhgw.entity.CodeEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.CodeRepository;
import com.hnyhgw.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl extends AbstractBaseServiceImpl<CodeEntity,String> implements CodeService {

    @Autowired
    private CodeRepository codeRepository;

    @Override
    public AbstractBaseRepository<CodeEntity, String> getAbstractBaseRepository() {
        return codeRepository;
    }

    @Override
    public Page<CodeEntity> findByPage(CommonRequestParamDto requestParamDto) {
        return null;
    }
}
