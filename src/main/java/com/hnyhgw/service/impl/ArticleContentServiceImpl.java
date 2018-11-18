package com.hnyhgw.service.impl;

import com.hnyhgw.entity.ArticleContentEntity;
import com.hnyhgw.repository.ArticleContentRepository;
import com.hnyhgw.service.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleContentServiceImpl implements ArticleContentService {
    @Autowired
    private ArticleContentRepository articleContentRepository;


    @Override
    public ArticleContentEntity findById(String id) {
        return articleContentRepository.findById(id).orElse(null);
    }
}
