package com.hnyhgw.service;

import java.io.Serializable;
import java.util.List;

public interface AbstractBaseService<T,ID extends Serializable> {

    void save(T entity);

    void deleteById(ID id);

    List<T> findAll();

    T findById(ID id);
}
