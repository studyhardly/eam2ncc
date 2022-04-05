package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.VZcczKpmx;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * (VZcczKpmx)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-28 08:38:55
 */
public interface VZcczKpmxDao {


    /**
     * 查询处置资产卡片明细
     *
     * @param ywid
     * @return
     */
    List<VZcczKpmx> queryZcczKpmx(@Param("ywid") String ywid);


}

