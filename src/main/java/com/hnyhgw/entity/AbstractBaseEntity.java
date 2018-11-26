package com.hnyhgw.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Date;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable{

    private String id;
    private Date createTime;
    private String createId;
    private Date updateTime;
    private String udpateId;

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
