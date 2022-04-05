package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.RJczczj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资产增加推送(RJczczj)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-01 14:32:22
 */
public interface RJczczjDao {

    /**
     * @param ywid
     * @return
     */

    List<RJczczj> queryByYwid(@Param("ywid") String ywid);

    /**
     * @param zcbmlist
     * @return
     */
    List<RJczczj> queryByZcbm(@Param("zcbmlist") String[] zcbmlist);


    int updateByZcbm(@Param("zcbmlist") String[] zcbmlist);


    int updateByYwid(@Param("ywid") String ywid);


}

