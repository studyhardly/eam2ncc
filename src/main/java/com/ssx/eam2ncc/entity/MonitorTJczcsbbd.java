package com.ssx.eam2ncc.entity;



import java.util.Date;
import java.io.Serializable;

/**
 * (MonitorTJczcsbbd)实体类
 *
 * @author youth
 * @since 2022-02-15 16:43:36
 */
public class MonitorTJczcsbbd implements Serializable {
    private static final long serialVersionUID = 539087727289903818L;
    
    private String tid;
    
    private String posummary;
    
    private Integer sysncstatus;
    
    private String sysncmessage;
    
    private Date sysncdate;
    
    private String compid;
    
    private Integer isnew;


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

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
    }

    public Integer getIsnew() {
        return isnew;
    }

    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

}

