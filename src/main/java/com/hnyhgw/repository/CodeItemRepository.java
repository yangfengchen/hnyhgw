package com.hnyhgw.repository;

import com.hnyhgw.entity.CodeItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CodeItemRepository extends AbstractBaseRepository<CodeItemEntity,String> {

    @Query("from CodeItemEntity t where t.type=:type")
    List<CodeItemEntity> findByType(@Param("type")String type);
}
