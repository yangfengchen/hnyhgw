package com.hnyhgw.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tbl_article_content", schema = "hnyngw", catalog = "")
public class ArticleContentEntity {
    private String id;
    private String titleName;
    private String content;
    private Date publishDate;
    private Date createTime;
    private String createId;
    private Date updateTime;
    private String udpateId;
    private String titleCode;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title_name")
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "publish_date")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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

    @Basic
    @Column(name = "title_code")
    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleContentEntity that = (ArticleContentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (titleName != null ? !titleName.equals(that.titleName) : that.titleName != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (publishDate != null ? !publishDate.equals(that.publishDate) : that.publishDate != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createId != null ? !createId.equals(that.createId) : that.createId != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (udpateId != null ? !udpateId.equals(that.udpateId) : that.udpateId != null) return false;
        if (titleCode != null ? !titleCode.equals(that.titleCode) : that.titleCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (titleName != null ? titleName.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createId != null ? createId.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (udpateId != null ? udpateId.hashCode() : 0);
        result = 31 * result + (titleCode != null ? titleCode.hashCode() : 0);
        return result;
    }
}
