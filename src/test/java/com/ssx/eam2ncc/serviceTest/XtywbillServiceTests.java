package com.ssx.eam2ncc.serviceTest;

import com.ssx.eam2ncc.entity.Xtywbill;
import com.ssx.eam2ncc.service.impl.XtywbillServiceImpl;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class XtywbillServiceTests {

    @Resource
    private XtywbillServiceImpl xtywbillService;

    @Test
    public void getInfoger() {
        Integer  typeid = 22;
        String  dwdh = "012K";
        Integer year =2022;
        Integer billid = 3;
        Xtywbill res =  xtywbillService.getBillInfo(typeid,dwdh,billid,year);
        System.out.println(res.getGid());
    }

    @Test
    public void getUserCode() throws Exception{
        String userCode = xtywbillService.getCreateUserCode(804,"xt22ywbill","zdr");
        System.out.println(userCode);
    }
}
