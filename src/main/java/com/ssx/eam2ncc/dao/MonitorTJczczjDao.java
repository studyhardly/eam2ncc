package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.MonitorTJczczj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (MonitorTJczczj)表数据库访问层
 *
 * @author youth
 * @since 2022-02-14 09:33:08
 */
public interface MonitorTJczczjDao {


    List<MonitorTJczczj> queryByFlag(@Param("isNew") Integer isNew );


    int updateFlagByTid(@Param("tid") String  tid,@Param("isNew") Integer isNew);

    List<MonitorTJczczj> queryByYwidAndStatus(@Param("ywid")String ywid,@Param("status") Integer status);
}

