package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.config.ApplicationContextProvider;
import com.ssx.eam2ncc.service.MonitorTJczcsbbdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * (MonitorTJczcsbbd)表控制层
 *
 * @author youth
 * @since 2022-02-15 16:43:36
 */
@RestController
@Slf4j
public class MonitorTJczcsbbdController {
    public void sendDingDingMessage() throws Exception {
        log.info("自动任务推送钉钉消息_资产信息变动");
        /**
         * 服务对象 因hutool线程安全，无法注入，使用上下文获取bean
         */
        MonitorTJczcsbbdService service = ApplicationContextProvider.getBean(MonitorTJczcsbbdService.class);
        String res = service.sendMessage(1);
        log.info("推送结果：{}", res);
    }

}

