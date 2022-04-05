package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.service.VDjZcczService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * (VDjZccz)表控制层
 *
 * @author makejava
 * @since 2021-12-28 11:25:31
 */
@RestController
@Slf4j
public class VDjZcczController {
    /**
     * 服务对象
     */
    @Resource
    private VDjZcczService vDjZcczService;


    @PostMapping("qryywid")
    public String qryYwid(@Param("dwdh") String dwdh, @Param("billid") String billid) {
        log.info("dwdh:{}",dwdh);
        log.info("billid,{}",billid);
        dwdh = dwdh.replaceAll("\\s+", "");
        billid = billid.replaceAll("\\s+", "");
        return this.vDjZcczService.qryYwid(dwdh, billid);
    }

}

