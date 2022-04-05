package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.entity.VZczjKpmx;
import com.ssx.eam2ncc.service.VZczjKpmxService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (VZczjKpmx)表控制层
 *
 * @author makejava
 * @since 2021-12-27 08:30:48
 */
@RestController
@Slf4j
public class VZczjKpmxController {
    /**
     * 服务对象
     */
    @Resource
    private VZczjKpmxService vZczjKpmxService;

    /**
     * @return
     */
    @PostMapping("zczj")
    public String queryKpmxByZcbm(@Param("code") String code) throws Exception {
        log.info("输入的资产编码：{}", code);
        code = code.replaceAll("\\s+", "");
        log.info("去空格回车后的资产编码：{}", code);
        String[] zcbms = code.split(",");
        String res = this.vZczjKpmxService.queryKpmxByZcbm(zcbms);
//        log.info("controller中的报文内容：{}",res);
        return res;
    }


}

