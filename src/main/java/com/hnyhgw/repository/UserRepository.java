package com.hnyhgw.repository;

import com.hnyhgw.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UserEntity,String>,JpaSpecificationExecutor<UserEntity> {
}
