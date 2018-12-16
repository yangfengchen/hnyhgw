/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hnyhgw.config.JsonDateSerializer;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class MenuBarVo {
    private Long id;
    private String entityId;
    private String type;
    private String name;
    private String url;
    private Integer sort;
    private Long parentId;
    private String entityParentId;
    private Boolean enable;
    private String childerId;
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date createTime;
    private String createId;
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date updateTime;
    private String udpateId;
}
