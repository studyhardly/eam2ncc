package com.ssx.eam2ncc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Xtywbill {
    private Integer gid;
    private String  dwdh;
    private Integer year ;
    private Integer billid ;
    private String typeid;
    private String summary;
}
