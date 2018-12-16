package com.hnyhgw.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_menu_bar", schema = "hnyhgw")
public class MenuBarEntity extends AbstractBaseEntity{
    private String type;
    private String name;
    private String url;
    private Integer sort;
    private String parentId;
    private Boolean enable;
    private String childerId;

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "enable")
    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Basic
    @Column(name = "childer_id")
    public String getChilderId() {
        return childerId;
    }

    public void setChilderId(String childerId) {
        this.childerId = childerId;
    }


}
