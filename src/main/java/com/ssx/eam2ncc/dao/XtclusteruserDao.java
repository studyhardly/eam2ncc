package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.Xtclusteruser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 系统集群在线用户登录信息(Xtclusteruser)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-29 08:17:15
 */
public interface XtclusteruserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  logid
     * @return 实例对象
     */
    List<Xtclusteruser> queryById(@Param("username") String username ,@Param("logid") String logid);

    /**
     *
     * @return
     */
    List<Xtclusteruser> queryAll();


    /**
     * 通过主键删除数据
     *
     * @param  logid
     * @return 影响行数
     */
    int deleteById(@Param("logid") String logid );

    int clearLockUser();
}

