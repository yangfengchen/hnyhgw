package com.hnyhgw.repository;

import com.hnyhgw.entity.ArticleContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleContentRepository extends JpaRepository<ArticleContentEntity,String>,JpaSpecificationExecutor<ArticleContentEntity> {
}
