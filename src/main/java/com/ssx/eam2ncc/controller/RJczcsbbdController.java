package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.entity.RJczcsbbd;
import com.ssx.eam2ncc.service.RJczcsbbdService;
import com.ssx.eam2ncc.service.XtywbillService;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 资产设备变动集成(RJczcsbbd)表控制层
 *
 * @author youth
 * @since 2022-02-10 15:03:05
 */
@RestController
@RequestMapping("zcbd")
public class RJczcsbbdController {
    /**
     * 服务对象
     */
    @Resource
    private RJczcsbbdService rJczcsbbdService;

    @Resource
    private XtywbillService xtywbillService;

    /**
     * 查询资产信息变动同步结果
     * @param dwdh
     * @param billid
     * @param year
     * @return
     */
    @PostMapping("sync_result")
    public RJczcsbbd getResult(@Param("dwdh") String dwdh ,@Param("billid") Integer billid ,@Param("year") Integer year,@Param("ywid") String ywid){

        //1、根据单位代号和单据编码和年份查询时，先查询单据ywid然后根据ywid查询同步结果
        if(ywid ==null){
            //根据单位代号dwdh ;单据编码 billid; 年份 year,单据类型id 查询单据业务id
            final  Integer typeid = 22;
            ywid = xtywbillService.getBillInfo(typeid,dwdh,billid,year).getGid().toString();
        }
        //2、根据ywid查询同步结果
        RJczcsbbd res = rJczcsbbdService.getResult(ywid);
        return res ;
    }

}

