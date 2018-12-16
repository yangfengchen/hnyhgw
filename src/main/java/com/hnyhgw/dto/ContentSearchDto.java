package com.hnyhgw.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ContentSearchDto extends CommonRequestParamDto{
    private String type;
    private String id;
}
