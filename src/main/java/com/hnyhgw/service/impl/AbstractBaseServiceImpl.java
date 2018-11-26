package com.hnyhgw.service.impl;

import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.service.AbstractBaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractBaseServiceImpl<T,ID extends Serializable> implements AbstractBaseService<T,ID> {

    public abstract AbstractBaseRepository<T,ID> getAbstractBaseRepository();

    @Override
    public void save(T entity) {
        getAbstractBaseRepository().save(entity);
    }

    @Override
    public void deleteById(ID id) {
        getAbstractBaseRepository().deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return  getAbstractBaseRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        return  getAbstractBaseRepository().findById(id).orElse(null);
    }
}
