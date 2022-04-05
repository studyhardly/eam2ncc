package com.ssx.eam2ncc.entity;

import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (MonitorTJczczj)实体类
 *
 * @author youth
 * @since 2022-02-14 09:33:08
 */
@ToString
public class MonitorTJczczj implements Serializable {
    private static final long serialVersionUID = 361831273091277599L;
    
    private String tid;
    
    private String posummary;
    
    private String sysncstatus;
    
    private String sysncmessage;
    
    private Date sysncdate;
    
    private String compid;
    
    private String isnew;


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

    public String getSysncstatus() {
        return sysncstatus;
    }

    public void setSysncstatus(String sysncstatus) {
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

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
    }

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

}

