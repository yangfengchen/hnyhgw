package com.hnyhgw.service;

import com.hnyhgw.dto.CommonRequestParamDto;
import com.hnyhgw.entity.AbstractBaseEntity;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public interface AbstractBaseService<T,ID extends Serializable> {

    void save(T entity);

    void deleteById(ID id);

    List<T> findAll();

    T findById(ID id);

    Page<T> findByPage(CommonRequestParamDto requestParamDto);

    void saveAll(List<T> entitys);
}
