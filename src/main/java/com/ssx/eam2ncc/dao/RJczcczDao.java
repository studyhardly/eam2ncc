package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.RJczccz;

import java.util.List;


/**
 * 资产处置推送(RJczccz)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-04 16:48:21
 */
public interface RJczcczDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    List<RJczccz> queryById(String tid);



}

