package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.MonitorTJczcsbbd;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (MonitorTJczcsbbd)表数据库访问层
 *
 * @author youth
 * @since 2022-02-15 16:43:36
 */
public interface MonitorTJczcsbbdDao {

    /**
     * 通过ID查询单条数据
     *
     * @param flag 主键
     * @return 实例对象
     */
    List<MonitorTJczcsbbd> queryByFlag(@Param("flag") Integer flag);


    int updateByYwid(@Param("ywid") String ywid, @Param("flag") Integer flag);



}

