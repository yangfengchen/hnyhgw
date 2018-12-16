package com.hnyhgw.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hnyhgw.dto.AjaxSimpleObject;
import com.hnyhgw.dto.ArticleTypeSearchDto;
import com.hnyhgw.dto.CommonRequestParamDto;
import com.hnyhgw.entity.ArticleTypeEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.ArticleTypeRepository;
import com.hnyhgw.service.ArticleTypeService;
import org.apache.commons.collections4.CollectionUtils;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ArticleTypeServiceImpl extends AbstractBaseServiceImpl<ArticleTypeEntity,String> implements ArticleTypeService {

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Override
    public AbstractBaseRepository<ArticleTypeEntity, String> getAbstractBaseRepository() {
        return articleTypeRepository;
    }

    @Override
    public Page<ArticleTypeEntity> findByPage(CommonRequestParamDto requestParamDto){
        ArticleTypeSearchDto articleTypeSearchDto = (ArticleTypeSearchDto) requestParamDto;

        //规格定义
        Specification<ArticleTypeEntity> specification = new Specification<ArticleTypeEntity>() {

            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<ArticleTypeEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if(StringUtils.isNotBlank(articleTypeSearchDto.getName())){ //添加断言
                    Predicate likeNickName = (Predicate) cb.like(root.get("name").as(String.class),articleTypeSearchDto.getName()+"%");
                    predicates.add(likeNickName);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }

        };
        //分页信息
        Pageable pageable = PageRequest.of(articleTypeSearchDto.getPageIndex(),articleTypeSearchDto.getLimit(),articleTypeSearchDto.getSort()); //页码：前端从1开始，jpa从0开始，做个转换
        //查询
        return getAbstractBaseRepository().findAll(specification,pageable);
    }

    @Override
    public Map<String,String> findSelectArticleTypeToMap(String name) {
        List<ArticleTypeEntity> articleTypeEntities = Lists.newArrayList();
        if(StringUtils.isNotBlank(name)){
            articleTypeEntities = articleTypeRepository.findByName(name);
        }else{
            articleTypeEntities = getAbstractBaseRepository().findAll();
        }
        Map<String,String> selectMap = Maps.newHashMap();
        if(CollectionUtils.isNotEmpty(articleTypeEntities)){
            selectMap = articleTypeEntities.parallelStream().collect(Collectors.toMap(ArticleTypeEntity::getId,ArticleTypeEntity::getName));
        }
        return selectMap;
    }
}
