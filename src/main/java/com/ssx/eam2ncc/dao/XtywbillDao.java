package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.Xtywbill;
import org.apache.ibatis.annotations.Param;

public interface XtywbillDao {

    Xtywbill getBillInfo(@Param("typeid") Integer typeid, @Param("dwdh")String dwdh , @Param("billid") Integer billid, @Param("year") Integer  year);


    Xtywbill getBillInfoByGid(@Param("gid") Integer gid);

    String getCreateUserCode(@Param("gid") Integer gid,@Param("ywdj") String ywdj, @Param("colname")String colname);
}
