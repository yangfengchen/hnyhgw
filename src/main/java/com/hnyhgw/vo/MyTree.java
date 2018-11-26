package com.hnyhgw.vo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class MyTree {
    private String id;
    private String name;
    private List<MyTree> items;
}
