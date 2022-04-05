package com.ssx.eam2ncc.entity;

import java.io.Serializable;

/**
 * 枚举以及枚举项表(Xtenumbank)实体类
 *
 * @author makejava
 * @since 2022-01-05 15:39:15
 */
public class Xtenumbank implements Serializable {
    private static final long serialVersionUID = 303019355546784801L;
    /**
     * 是否允许修改标志，0-允许修改，1--不允许修改
     */
    private String bz1;
    /**
     * 枚举类型ID
     */
    private String enumlxid;
    /**
     * 0或空表示未停用，1表示停用
     */
    private Double stoped;
    /**
     * COMPANYINFO表中对应的单位代号
     */
    private String compid;
    /**
     * 枚举类型名称
     */
    private String enumid;
    /**
     * 枚举类型名称
     */
    private String enumlxmc;
    /**
     * 枚举值
     */
    private String enumvalue;


    public String getBz1() {
        return bz1;
    }

    public void setBz1(String bz1) {
        this.bz1 = bz1;
    }

    public String getEnumlxid() {
        return enumlxid;
    }

    public void setEnumlxid(String enumlxid) {
        this.enumlxid = enumlxid;
    }

    public Double getStoped() {
        return stoped;
    }

    public void setStoped(Double stoped) {
        this.stoped = stoped;
    }

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
    }

    public String getEnumid() {
        return enumid;
    }

    public void setEnumid(String enumid) {
        this.enumid = enumid;
    }

    public String getEnumlxmc() {
        return enumlxmc;
    }

    public void setEnumlxmc(String enumlxmc) {
        this.enumlxmc = enumlxmc;
    }

    public String getEnumvalue() {
        return enumvalue;
    }

    public void setEnumvalue(String enumvalue) {
        this.enumvalue = enumvalue;
    }

}

