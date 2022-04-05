package com.ssx.eam2ncc.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 资产处置推送(RJczccz)实体类
 *
 * @author makejava
 * @since 2022-01-04 16:48:21
 */
@Data
public class RJczccz implements Serializable {
    private static final long serialVersionUID = 562780639769283432L;
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
     * 填报人
     */
    private String tbr;
    /**
     * 制单日期
     */
    private String zdrq;
    /**
     * 结果标识
     */
    private String rspcode;
    /**
     * 结果标识
     */
    private String rspmsg;


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

    public String getTbr() {
        return tbr;
    }

    public void setTbr(String tbr) {
        this.tbr = tbr;
    }

    public String getZdrq() {
        return zdrq;
    }

    public void setZdrq(String zdrq) {
        this.zdrq = zdrq;
    }

    public String getRspcode() {
        return rspcode;
    }

    public void setRspcode(String rspcode) {
        this.rspcode = rspcode;
    }

    public String getRspmsg() {
        return rspmsg;
    }

    public void setRspmsg(String rspmsg) {
        this.rspmsg = rspmsg;
    }

}

