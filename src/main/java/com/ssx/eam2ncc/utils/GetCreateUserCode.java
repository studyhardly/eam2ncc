package com.ssx.eam2ncc.utils;

import com.ssx.eam2ncc.entity.Xtywbill;
import com.ssx.eam2ncc.service.XtywbillService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GetCreateUserCode {
    @Resource
    XtywbillService xtywbillService;


    public String getUserCode(String ywid,String colname) throws Exception {
        //根据单据ywid查询制单人
        Xtywbill ywdj = xtywbillService.getBillInfoByGid(Integer.parseInt(ywid));
        String typtId = ywdj.getTypeid();
        String tableName = "XT" + typtId + "YWBILL";
        String userCode = xtywbillService.getCreateUserCode(Integer.parseInt(ywid), tableName,colname);
        if (userCode.length() == 6) {
            return userCode;
        }
        return null;
    }
}
