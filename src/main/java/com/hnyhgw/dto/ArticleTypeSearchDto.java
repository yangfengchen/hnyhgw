package com.hnyhgw.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ArticleTypeSearchDto extends CommonRequestParamDto{
    private String name;
}
