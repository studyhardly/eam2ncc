package com.ssx.eam2ncc.serviceTest;

import com.ssx.eam2ncc.service.MonitorTZcczService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZcczSendDDMessageTests {

    @Resource
    private MonitorTZcczService service;

    @Test
    public void sendMes() throws Exception {
        this.service.sendDingDingMessages(1);
    }

    @Test
    public void update(){
        this.service.update("1223",1);
    }
}
