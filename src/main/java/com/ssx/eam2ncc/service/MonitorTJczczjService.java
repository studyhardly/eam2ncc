package com.ssx.eam2ncc.service;

/**
 * (MonitorTJczczj)表服务接口
 *
 * @author youth
 * @since 2022-02-14 09:33:08
 */
public interface MonitorTJczczjService {

    /**
     *  根据标识flag查询数据
     * @param
     * @return
     */
   String sendDingDingMessage() throws Exception;

    /**
     * 根据tid修改标识falg
     * @param tid 主键id
     * @param isNew 最新标识
     * @return
     */
   Integer updateFlagByTid(String tid,Integer isNew);

}
