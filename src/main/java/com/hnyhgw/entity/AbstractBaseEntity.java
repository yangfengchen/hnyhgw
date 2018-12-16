package com.hnyhgw.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hnyhgw.config.JsonDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable{

    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date createTime;
    private String createId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date updateTime;
    private String udpateId;

    public AbstractBaseEntity(){
        this.updateTime = new Date();
        this.createTime = new Date();
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "create_id")
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "udpate_id")
    public String getUdpateId() {
        return udpateId;
    }

    public void setUdpateId(String udpateId) {
        this.udpateId = udpateId;
    }
}
