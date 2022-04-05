package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.VDjZccz;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (VDjZccz)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-28 11:25:31
 */
public interface VDjZcczDao {

    VDjZccz qryYwid(@Param("dwdh") String dwdh,@Param("billid") String billid );


}

