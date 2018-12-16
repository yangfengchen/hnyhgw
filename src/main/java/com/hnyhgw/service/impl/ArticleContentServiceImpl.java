package com.hnyhgw.service.impl;

import com.hnyhgw.dto.ArticleContentSearchDto;
import com.hnyhgw.dto.ArticleTypeSearchDto;
import com.hnyhgw.dto.CommonRequestParamDto;
import com.hnyhgw.entity.ArticleContentEntity;
import com.hnyhgw.entity.ArticleTypeEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.ArticleContentRepository;
import com.hnyhgw.service.ArticleContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleContentServiceImpl extends AbstractBaseServiceImpl<ArticleContentEntity,String> implements ArticleContentService {

    @Autowired
    private ArticleContentRepository articleContentRepository;

    @Override
    public AbstractBaseRepository<ArticleContentEntity, String> getAbstractBaseRepository() {
        return articleContentRepository;
    }

    @Override
    public Page<ArticleContentEntity> findByPage(CommonRequestParamDto requestParamDto) {
        ArticleContentSearchDto articleContentSearchDto = (ArticleContentSearchDto) requestParamDto;

        //规格定义
        Specification<ArticleContentEntity> specification = new Specification<ArticleContentEntity>() {

            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<ArticleContentEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if(StringUtils.isNotBlank(articleContentSearchDto.getTitleName())){ //添加断言
                    Predicate likeNickName = (Predicate) cb.like(root.get("titleName").as(String.class),"%"+articleContentSearchDto.getTitleName()+"%");
                    predicates.add(likeNickName);
                }
                if(StringUtils.isNotBlank(articleContentSearchDto.getArticleTypeId())){ //添加断言
                    Predicate likeNickName = (Predicate) cb.equal(root.get("articleTypeId").as(String.class),articleContentSearchDto.getArticleTypeId());
                    predicates.add(likeNickName);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }

        };
        //分页信息
        Pageable pageable = PageRequest.of(articleContentSearchDto.getPageIndex(),articleContentSearchDto.getLimit(),articleContentSearchDto.getSort()); //页码：前端从1开始，jpa从0开始，做个转换
        //查询
        return getAbstractBaseRepository().findAll(specification,pageable);
    }
}
