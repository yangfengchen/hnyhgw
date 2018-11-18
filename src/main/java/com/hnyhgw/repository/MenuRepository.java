package com.hnyhgw.repository;

import com.hnyhgw.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuRepository extends JpaRepository<MenuEntity,String>,JpaSpecificationExecutor<MenuEntity> {
}
