package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.Xtenumbank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 枚举以及枚举项表(Xtenumbank)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-05 15:39:15
 */
public interface XtenumbankDao {


    List<Xtenumbank> query(@Param("enumlxid") String enumlxid, @Param("enumlxmc") String enumlxmc, @Param("enumvalue") String enumvalue);

}

