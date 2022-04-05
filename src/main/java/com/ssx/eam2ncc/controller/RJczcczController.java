package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.entity.RJczccz;
import com.ssx.eam2ncc.service.RJczcczService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资产处置推送(RJczccz)表控制层
 *
 * @author makejava
 * @since 2022-01-04 16:48:21
 */
@RestController
@RequestMapping("rJczccz")
public class RJczcczController {
    /**
     * 服务对象
     */
    @Resource
    private RJczcczService rJczcczService;

    /**
     *
     * @param ywid
     * @return
     */
    @PostMapping("zccz")
    public List<RJczccz> queryByPage(@Param("ywid") String ywid) {
        return this.rJczcczService.queryById(ywid);
    }


}

