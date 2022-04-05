package com.ssx.eam2ncc.entity;

import java.io.Serializable;

/**
 * (VDjZccz)实体类
 *
 * @author makejava
 * @since 2021-12-28 11:25:31
 */
public class VDjZccz implements Serializable {
    private static final long serialVersionUID = -49826892021942705L;

    private Long ywid;

    private String dwdh;

    private Long billid;

    private String summary;

    private String createtime;

    private String tbr;

    private String tbrname;


    public Long getYwid() {
        return ywid;
    }

    public void setYwid(Long ywid) {
        this.ywid = ywid;
    }

    public String getDwdh() {
        return dwdh;
    }

    public void setDwdh(String dwdh) {
        this.dwdh = dwdh;
    }

    public Long getBillid() {
        return billid;
    }

    public void setBillid(Long billid) {
        this.billid = billid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTbr() {
        return tbr;
    }

    public void setTbr(String tbr) {
        this.tbr = tbr;
    }

    public String getTbrname() {
        return tbrname;
    }

    public void setTbrname(String tbrname) {
        this.tbrname = tbrname;
    }

}

