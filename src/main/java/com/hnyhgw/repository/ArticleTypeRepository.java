package com.hnyhgw.repository;

import com.hnyhgw.entity.ArticleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleTypeRepository extends JpaRepository<ArticleTypeEntity,String>,JpaSpecificationExecutor<ArticleTypeEntity> {
}
