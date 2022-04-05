package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.service.VZcczKpmxService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (VZcczKpmx)表控制层
 *
 * @author makejava
 * @since 2021-12-28 08:38:55
 */
@RestController
@Slf4j
public class VZcczKpmxController {
    /**
     * 服务对象
     */
    @Resource
    private VZcczKpmxService vZcczKpmxService;


    @PostMapping("zccz")
    public String queryByPage(@Param("code") String code) {
        log.info("输入的业务ID：{}", code);
        code = code.replaceAll("\\s+", "");
        log.info("去空格回车后的业务id：{}", code);
        return this.vZcczKpmxService.queryZcczKpmx(code);
    }

}

