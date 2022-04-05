package com.ssx.eam2ncc.service;


import com.ssx.eam2ncc.entity.MonitorTJczcsbbd;

import java.util.List;

/**
 * (MonitorTJczcsbbd)表服务接口
 *
 * @author youth
 * @since 2022-02-15 16:43:36
 */
public interface MonitorTJczcsbbdService {

    /**
     * 查询资产设备变动单据
     * @param flag
     * @return
     */
    String sendMessage(Integer flag) throws Exception;


    /**
     * 根据tid 修改最新标识
     * @param tid
     * @param flag
     * @return
     */
    Integer updateFlagByTid(String tid,Integer flag);
}
