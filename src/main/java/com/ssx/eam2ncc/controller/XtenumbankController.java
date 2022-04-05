package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.entity.Xtenumbank;
import com.ssx.eam2ncc.service.XtenumbankService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 枚举以及枚举项表(Xtenumbank)表控制层
 *
 * @author makejava
 * @since 2022-01-05 15:39:15
 */
@RestController
@RequestMapping("enum")
@Slf4j
public class XtenumbankController {
    /**
     * 服务对象
     */
    @Resource
    private XtenumbankService xtenumbankService;

    /**
     * @param enumlxid
     * @param enumlxmc
     * @param enumvalue
     * @return
     */
    @GetMapping("list")
    public List<Xtenumbank> queryByPage(@Param("enumlxid") String enumlxid, @Param("enumlxmc") String enumlxmc, @Param("enumvalue") String enumvalue) {

        log.info("enumlxid:{}",enumlxid);
        log.info("enumlxmc:{}",enumlxmc);
        log.info("enumvalue:{}",enumvalue);

        return this.xtenumbankService.query(enumlxid, enumlxmc, enumvalue);
    }
}

