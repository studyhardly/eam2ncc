package com.ssx.eam2ncc.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 资产增加推送(RJczczj)实体类
 *
 * @author makejava
 * @since 2022-01-01 14:32:22
 */
@Data
public class RJczczj implements Serializable {
    private static final long serialVersionUID = 197732749836812971L;
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
    private int sysncstatus;
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
    /**
     * 对象序列化的字符串
     */
  //  private String modelstr;
    /**
     * 原始对象序列化的字符串
     */
  //  private String modelstrcurr;
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
     * 开始使用日期
     */
    private String kssyrq;
    /**
     * 入账日期
     */
    private String rzrq;
    /**
     * 项目名称
     */
    private String xmmc;


}

