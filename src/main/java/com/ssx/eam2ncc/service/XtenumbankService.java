package com.ssx.eam2ncc.service;

import com.ssx.eam2ncc.entity.Xtenumbank;

import java.util.List;

/**
 * 枚举以及枚举项表(Xtenumbank)表服务接口
 *
 * @author makejava
 * @since 2022-01-05 15:39:15
 */
public interface XtenumbankService {

    /**
     * @param enumlixd
     * @param enumlxmc
     * @param enumvalue
     * @return
     */
    List<Xtenumbank> query(String enumlixd, String enumlxmc , String enumvalue);


}
