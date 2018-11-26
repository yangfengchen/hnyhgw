package com.hnyhgw.service.impl;

import com.hnyhgw.entity.ArticleContentEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.ArticleContentRepository;
import com.hnyhgw.service.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ArticleContentServiceImpl extends AbstractBaseServiceImpl<ArticleContentEntity,String> implements ArticleContentService {

    @Autowired
    private ArticleContentRepository articleContentRepository;

    @Override
    public AbstractBaseRepository<ArticleContentEntity, String> getAbstractBaseRepository() {
        return articleContentRepository;
    }

}
