package com.hnyhgw.repository;

import com.hnyhgw.entity.ArticleTypeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface ArticleTypeRepository  extends AbstractBaseRepository<ArticleTypeEntity,String> {

    @Query("from ArticleTypeEntity t where t.enable=true and t.name like concat('%',:name,'%') order by t.updateTime desc")
    List<ArticleTypeEntity> findByName(@Param("name")String name);
}
