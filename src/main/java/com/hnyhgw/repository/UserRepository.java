package com.hnyhgw.repository;

import com.hnyhgw.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends AbstractBaseRepository<UserEntity,String> {

    @Query(" from UserEntity t where t.name=:name")
    UserEntity findByName(@Param("name")String name);
}
