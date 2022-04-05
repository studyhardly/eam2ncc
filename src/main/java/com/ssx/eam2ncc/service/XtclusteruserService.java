package com.ssx.eam2ncc.service;

import com.ssx.eam2ncc.entity.Xtclusteruser;

import java.util.List;

/**
 * 系统集群在线用户登录信息(Xtclusteruser)表服务接口
 *
 * @author makejava
 * @since 2021-12-29 08:17:17
 */
public interface XtclusteruserService {

    /**
     * 通过ID查询单条数据
     *
     * @param  logid
     * @return 实例对象
     */
    List<Xtclusteruser> queryById(String username ,String logid );

    /**
     *
     * @return
     */
    List<Xtclusteruser> queryAll();



    /**
     * 通过主键删除数据
     *
     * @param  logid
     * @return 是否成功
     */
    boolean deleteById(String logid );

    /**
     * 清除锁定用户
     */
    String clearLockUser();
}
