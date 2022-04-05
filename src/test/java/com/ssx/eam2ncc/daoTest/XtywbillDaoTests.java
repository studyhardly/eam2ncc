package com.ssx.eam2ncc.daoTest;

import com.ssx.eam2ncc.dao.XtywbillDao;
import com.ssx.eam2ncc.entity.Xtywbill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class XtywbillDaoTests {

    @Resource
    private XtywbillDao xtywbillDao;

    @Test
    public void getGid(){

        Integer  typeid = 22;
        String  dwdh = "012K";
        Integer year =2022;
        Integer billid = 3;
       Xtywbill res =  xtywbillDao.getBillInfo(typeid,dwdh,billid,year);
        System.out.println(res.getGid());
    }



}
