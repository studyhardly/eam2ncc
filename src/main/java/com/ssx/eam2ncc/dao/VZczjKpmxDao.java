package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.VZczjKpmx;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * (VZczjKpmx)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-27 08:30:49
 */
public interface VZczjKpmxDao {


    List<VZczjKpmx> queryKpmxByZcbm(@Param("zcbmlist") String[] zcbmlist);


}

