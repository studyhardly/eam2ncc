package com.ssx.eam2ncc.serviceTest;


import com.ssx.eam2ncc.entity.MonitorTJczcsbbd;
import com.ssx.eam2ncc.service.MonitorTJczcsbbdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZcsbbdServiceTest {

    @Resource
    private MonitorTJczcsbbdService service;

    @Test
    public void getZcsbbdInfoger() throws Exception {
         service.sendMessage(1);
    }

    @Test
    public void updateFlag() {
        service.updateFlagByTid("142805", 1);
    }
}
