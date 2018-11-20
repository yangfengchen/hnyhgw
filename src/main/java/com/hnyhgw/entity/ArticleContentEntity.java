package com.hnyhgw.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tbl_article_content", schema = "hnyngw", catalog = "")
public class ArticleContentEntity extends AbstractBaseEntity{

    private String titleName;
    private String content;
    private Date publishDate;
    private String titleCode;

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
    @Column(name = "title_code")
    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

}
