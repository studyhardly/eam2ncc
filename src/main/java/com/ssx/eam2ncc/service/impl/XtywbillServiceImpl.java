package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.dao.XtywbillDao;
import com.ssx.eam2ncc.entity.Xtywbill;
import com.ssx.eam2ncc.service.XtywbillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("xtywbillService")
public class XtywbillServiceImpl implements XtywbillService {
    @Resource
    private XtywbillDao xtywbillDao;
    @Override
    public Xtywbill getBillInfo(Integer typeid, String dwdh, Integer billid, Integer year) {
        return xtywbillDao.getBillInfo(typeid,dwdh,billid,year);
    }

    @Override
    public Xtywbill getBillInfoByGid(Integer gid) {
        return xtywbillDao.getBillInfoByGid(gid);
    }

    /**
     * 根据gid 业务单据查询制单人
     *
     * @param gid
     * @param ywdj
     * @return
     */
    @Override
    public String getCreateUserCode (Integer gid, String ywdj,String colname) throws  Exception{
        return xtywbillDao.getCreateUserCode(gid,ywdj,colname);
    }
}
