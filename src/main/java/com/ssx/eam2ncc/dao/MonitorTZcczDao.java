package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.MonitorTZccz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (MonitorTZccz)表数据库访问层
 *
 * @author youth
 * @since 2022-02-16 12:00:57
 */
public interface MonitorTZcczDao {

    List<MonitorTZccz> queryAllByFlag(@Param("isNew")Integer isNew);


    int update(@Param("tid") String tid, @Param("isNew")Integer isNew);

}

