package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.entity.RJczczj;
import com.ssx.eam2ncc.service.RJczczjService;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资产增加推送(RJczczj)表控制层
 *
 * @author makejava
 * @since 2022-01-01 14:32:22
 */
@RestController
@Slf4j
@RequestMapping("sync")
public class RJczczjController {
    /**
     * 服务对象
     */
    @Resource
    private RJczczjService rJczczjService;

    @PostMapping("zcbm")
    List<RJczczj> queryByZcbm(@Param("code") String code) {
        log.info("输入的资产编码：{}", code);
        code = code.replaceAll("\\s+", "");
        log.info("去空格回车后的资产编码：{}", code);
        String[] zcbms = code.split(",");
        return this.rJczczjService.queryByZcbm(zcbms);
    }

    ;

    @PostMapping("ywid")
    List<RJczczj> queryByYwid(@Param("code") String code) {
        log.info("输入的资产编码：{}", code);
        code = code.replaceAll("\\s+", "");
        log.info("去空格回车后的资产编码：{}", code);
        return this.rJczczjService.queryByYwid(code);
    }


    @PostMapping("chbyzcbm")
    int changeSyncStatusByZcbm(@Param("code") String code) {
        log.info("重发的资产编码：{}", code);
        code = code.replaceAll("\\s+", "");
        log.info("去空格回车后重发的资产编码：{}", code);
        String[] codes = code.split(",");
        return this.rJczczjService.updateByZcbm(codes);

    }

    @PostMapping("chbyywid")
    int changeSyncStatusByYwid(@Param("ywid") String code) {
        log.info("输入的资产编码：{}", code);
        code = code.replaceAll("\\s+", "");
        log.info("去空格回车后的资产编码：{}", code);
        return this.rJczczjService.updateByYwid(code);
    }

}

