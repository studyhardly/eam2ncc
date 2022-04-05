package com.ssx.eam2ncc.service;

import ch.qos.logback.core.util.InvocationGate;
import com.ssx.eam2ncc.entity.Xtywbill;

public interface XtywbillService {

    /**
     * 获取单据信息
     * @param typeid 单据typeid
     * @param dwdh 单位代号
     * @param billid 单据编号
     * @param year 业务年份
     * @return
     */
    Xtywbill getBillInfo(Integer typeid, String dwdh, Integer billid ,Integer year);

    /**
     * 根据Gid获取单据信息
     * @param gid 单据gid
     * @return
     */
    Xtywbill getBillInfoByGid(Integer gid);

    /**
     * 根据gid 业务单据查询制单人
     * @param gid
     * @param ywdj
     * @return
     */
    String getCreateUserCode(Integer gid,String ywdj,String colname) throws Exception;



}
