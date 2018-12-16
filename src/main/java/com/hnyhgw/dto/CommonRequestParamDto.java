/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.dto;


import com.google.common.collect.Lists;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;


public class CommonRequestParamDto implements Serializable {
    private Integer limit;
    private Integer offset;
    private Integer pageIndex;
    private Sort sort;

    public Integer getLimit() {
        return limit == null ? 10 : limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset == null ? 0 : offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageIndex() {
        return getOffset()/getLimit();
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Sort getSort() {
        if(sort == null){
           List<Sort.Order> orders = Lists.newArrayList();
           orders.add(new Sort.Order(Sort.Direction.DESC,"updateTime"));
           orders.add(new Sort.Order(Sort.Direction.DESC,"id"));
           sort = Sort.by(orders);
        }
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
