package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.RJczcsbbd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资产设备变动集成(RJczcsbbd)表数据库访问层
 *
 * @author youth
 * @since 2022-02-10 15:03:07
 */
public interface RJczcsbbdDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    RJczcsbbd queryById(String tid);


}

