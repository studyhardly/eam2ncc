package com.ssx.eam2ncc.service;



/**
 * (MonitorTZccz)表服务接口
 *
 * @author youth
 * @since 2022-02-16 12:00:58
 */
public interface MonitorTZcczService {

   String sendDingDingMessages(Integer isNew) throws Exception;

   Integer update(String tid,Integer isNew);

}
