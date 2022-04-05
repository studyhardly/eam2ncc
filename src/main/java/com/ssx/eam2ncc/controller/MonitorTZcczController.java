package com.ssx.eam2ncc.controller;


import com.ssx.eam2ncc.config.ApplicationContextProvider;
import com.ssx.eam2ncc.service.MonitorTJczcsbbdService;
import com.ssx.eam2ncc.service.MonitorTZcczService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MonitorTZccz)表控制层
 *
 * @author youth
 * @since 2022-02-16 12:00:56
 */
@RestController
@RequestMapping("monitorTZccz")
@Slf4j
public class MonitorTZcczController {
    public void sendDingDingMessage() throws Exception {
        log.info("自动任务推送钉钉消息_资产处置");
        /**
         * 服务对象 因hutool线程安全，无法注入，使用上下文获取bean
         */
        MonitorTZcczService service = ApplicationContextProvider.getBean(MonitorTZcczService.class);
        String res = service.sendDingDingMessages(1);
        log.info("推送结果：{}", res);
    }
}
