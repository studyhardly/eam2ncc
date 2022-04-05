package com.ssx.eam2ncc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统集群在线用户登录信息(Xtclusteruser)实体类
 *
 * @author makejava
 * @since 2021-12-29 08:17:15
 */
public class Xtclusteruser implements Serializable {
    private static final long serialVersionUID = -41341147644349305L;
    /**
     * 登入类型
     */
    private Long logintype;
    /**
     * B版登入标志
     */
    private Long isweblogon;
    /**
     * C版登入标志
     */
    private Long isexelogon;
    /**
     * 用户IP
     */
    private String ip;
    /**
     * 登入时间
     */
    private Date logondate;
    /**
     * 最后访问时间
     */
    private Date lastaccessdate;
    /**
     * 主机名
     */
    private String host;
    /**
     * 单位代号，引用自XTDW.DH
     */
    private String companycode;
    /**
     * 用户ID
     */
    private Long userid;
    /**
     * 用户名，引用自XTYHXX.XSMC
     */
    private String username;
    /**
     * 集群名称
     */
    private String clustername;
    /**
     * 登入名，引用自XTYHXX.YHMC
     */
    private String logid;


    public Long getLogintype() {
        return logintype;
    }

    public void setLogintype(Long logintype) {
        this.logintype = logintype;
    }

    public Long getIsweblogon() {
        return isweblogon;
    }

    public void setIsweblogon(Long isweblogon) {
        this.isweblogon = isweblogon;
    }

    public Long getIsexelogon() {
        return isexelogon;
    }

    public void setIsexelogon(Long isexelogon) {
        this.isexelogon = isexelogon;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLogondate() {
        return logondate;
    }

    public void setLogondate(Date logondate) {
        this.logondate = logondate;
    }

    public Date getLastaccessdate() {
        return lastaccessdate;
    }

    public void setLastaccessdate(Date lastaccessdate) {
        this.lastaccessdate = lastaccessdate;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClustername() {
        return clustername;
    }

    public void setClustername(String clustername) {
        this.clustername = clustername;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

}

