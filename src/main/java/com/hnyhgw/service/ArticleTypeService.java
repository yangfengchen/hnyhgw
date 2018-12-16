package com.hnyhgw.service;

import com.hnyhgw.dto.AjaxSimpleObject;
import com.hnyhgw.entity.ArticleTypeEntity;

import java.util.List;
import java.util.Map;

public interface ArticleTypeService extends AbstractBaseService<ArticleTypeEntity,String>{

    Map<String,String> findSelectArticleTypeToMap(String name);
}
