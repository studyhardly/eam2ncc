package com.ssx.eam2ncc.serviceTest;

import com.ssx.eam2ncc.service.IDingTalkService;
import com.ssx.eam2ncc.service.MonitorTJczczjService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DingDingServiceTest {
    @Resource
    private MonitorTJczczjService monitorTJczczjService;

    @Resource
    IDingTalkService dingTalkService;

    @Test
    public void sendMes() throws Exception {
        monitorTJczczjService.sendDingDingMessage();
    }

    @Test
    public void sendDbMes() throws Exception {
        dingTalkService.sendDbMessage();
    }

@Test
    public void updateDbMes() throws Exception {
        dingTalkService.updateDbMessage("851143","123456");
    }
}
