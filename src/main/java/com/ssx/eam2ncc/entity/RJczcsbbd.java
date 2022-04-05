package com.ssx.eam2ncc.entity;

import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 资产设备变动集成(RJczcsbbd)实体类
 *
 * @author youth
 * @since 2022-02-10 15:03:07
 */
@ToString
public class RJczcsbbd implements Serializable {
    private static final long serialVersionUID = -45321272433704588L;
    /**
     * 惟一键
     */
    private String tid;
    /**
     * 数据摘要
     */
    private String posummary;
    /**
     * 同步状态
     */
    private String sysncstatus;
    /**
     * 同步信息
     */
    private String sysncmessage;
    /**
     * 同步信息日志
     */
    private String sysncmessagelog;
    /**
     * 同步时间
     */
    private Date sysncdate;
    /**
     * 单位
     */
    private String compid;
    /**
     * 引用日志表ID
     */
    private String logid;
/*    *//**
     * 对象序列化的字符串
     *//*
    private String modelstr;
    *//**
     * 原始对象序列化的字符串
     *//*
    private String modelstrcurr;*/
    /**
     * 重发地址
     */
    private String resendurl;
    /**
     * 调用者
     */
    private String invokeurl;
    /**
     * 调用者地址
     */
    private String invokeaddress;
    /**
     * 父ID
     */
    private String pid;
    /**
     * 批次号
     */
    private String pc;
    /**
     * 写入的集成平台地址
     */
    private String ipport;
    /**
     * 处理耗时
     */
    private String handletime;
    /**
     * 错误类型
     */
    private String errortype;
    /**
     * 错误日志
     */
    private String errorlog;
    /**
     * 自动失败重发次数
     */
    private String autoresend;
    /**
     * 是否正在重发
     */
    private String resendflag;
    /**
     * 错误编码
     */
    private String errorcode;
    /**
     * 制单人
     */
    private String zdr;
    /**
     * 制单日期
     */
    private String ttime;


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

    public String getSysncmessagelog() {
        return sysncmessagelog;
    }

    public void setSysncmessagelog(String sysncmessagelog) {
        this.sysncmessagelog = sysncmessagelog;
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

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

/*    public String getModelstr() {
        return modelstr;
    }

    public void setModelstr(String modelstr) {
        this.modelstr = modelstr;
    }

    public String getModelstrcurr() {
        return modelstrcurr;
    }

    public void setModelstrcurr(String modelstrcurr) {
        this.modelstrcurr = modelstrcurr;
    }*/

    public String getResendurl() {
        return resendurl;
    }

    public void setResendurl(String resendurl) {
        this.resendurl = resendurl;
    }

    public String getInvokeurl() {
        return invokeurl;
    }

    public void setInvokeurl(String invokeurl) {
        this.invokeurl = invokeurl;
    }

    public String getInvokeaddress() {
        return invokeaddress;
    }

    public void setInvokeaddress(String invokeaddress) {
        this.invokeaddress = invokeaddress;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getIpport() {
        return ipport;
    }

    public void setIpport(String ipport) {
        this.ipport = ipport;
    }

    public String getHandletime() {
        return handletime;
    }

    public void setHandletime(String handletime) {
        this.handletime = handletime;
    }

    public String getErrortype() {
        return errortype;
    }

    public void setErrortype(String errortype) {
        this.errortype = errortype;
    }

    public String getErrorlog() {
        return errorlog;
    }

    public void setErrorlog(String errorlog) {
        this.errorlog = errorlog;
    }

    public String getAutoresend() {
        return autoresend;
    }

    public void setAutoresend(String autoresend) {
        this.autoresend = autoresend;
    }

    public String getResendflag() {
        return resendflag;
    }

    public void setResendflag(String resendflag) {
        this.resendflag = resendflag;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getZdr() {
        return zdr;
    }

    public void setZdr(String zdr) {
        this.zdr = zdr;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

}

