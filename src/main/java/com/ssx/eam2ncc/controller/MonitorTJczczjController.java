package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.config.ApplicationContextProvider;
import com.ssx.eam2ncc.entity.MonitorTJczczj;
import com.ssx.eam2ncc.service.MonitorTJczczjService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

/**
 * (MonitorTJczczj)表控制层
 *
 * @author youth
 * @since 2022-02-14 09:33:08
 */
@Slf4j
@Controller
public class MonitorTJczczjController {

    public void sendDingDingMessage() throws Exception {
        log.info("自动任务推送钉钉消息");
        /**
         * 服务对象 因hutool线程安全，无法注入，使用上下文获取bean
         */
        MonitorTJczczjService monitorTJczczjService = ApplicationContextProvider.getBean(MonitorTJczczjService.class);
        String res = monitorTJczczjService.sendDingDingMessage();
        log.info("推送结果：{}", res);
    }

}

