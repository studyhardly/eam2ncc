package com.ssx.eam2ncc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (MonitorTZccz)实体类
 *
 * @author youth
 * @since 2022-02-16 12:00:57
 */
public class MonitorTZccz implements Serializable {
    private static final long serialVersionUID = -71668610820093922L;

    private String tid;

    private String posummary;

    private Integer sysncstatus;

    private String sysncmessage;

    private Date sysncdate;

    private Integer isnew;

    private String tbr;


    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getPosummary() {
        return posummary;
    }

    public void setPosummary(String posummary) {
        this.posummary = posummary;
    }

    public Integer getSysncstatus() {
        return sysncstatus;
    }

    public void setSysncstatus(Integer sysncstatus) {
        this.sysncstatus = sysncstatus;
    }

    public String getSysncmessage() {
        return sysncmessage;
    }

    public void setSysncmessage(String sysncmessage) {
        this.sysncmessage = sysncmessage;
    }

    public Date getSysncdate() {
        return sysncdate;
    }

    public void setSysncdate(Date sysncdate) {
        this.sysncdate = sysncdate;
    }

    public Integer getIsnew() {
        return isnew;
    }

    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

    public String getTbr() {
        return tbr;
    }

    public void setTbr(String tbr) {
        this.tbr = tbr;
    }

}

