package com.hnyhgw.repository;

import com.hnyhgw.entity.MenuBarEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MenuBarRepository extends AbstractBaseRepository<MenuBarEntity,String> {

    @Query("from MenuBarEntity t where t.enable=true")
    List<MenuBarEntity> findByEnable();

    @Query("from MenuBarEntity t where t.enable=true and t.id=:parentId")
    MenuBarEntity findByParentId(@Param("parentId")String parentId);

    @Query("from MenuBarEntity t where t.enable=true and t.parentId=:parentId")
    List<MenuBarEntity> findChilderByParentId(@Param("parentId")String parentId);

    @Modifying
    @Query("delete from MenuBarEntity t where t.parentId=:parentId")
    void deleteByParentId(@Param("parentId")String parentId);
}
