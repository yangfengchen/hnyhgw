package com.hnyhgw.service.impl;

import com.hnyhgw.entity.ArticleTypeEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.ArticleTypeRepository;
import com.hnyhgw.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleTypeServiceImpl extends AbstractBaseServiceImpl<ArticleTypeEntity,String> implements ArticleTypeService {

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Override
    public AbstractBaseRepository<ArticleTypeEntity, String> getAbstractBaseRepository() {
        return articleTypeRepository;
    }
}
