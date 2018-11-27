package com.hnyhgw.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @创建时间 2018/9/22
 * @描述
 */
@Getter
@Setter
@Builder
public class AjaxResultVo {

    //状态
    private String status;
    //信息
    private String message;
    //数据体
    private Object data;

}
