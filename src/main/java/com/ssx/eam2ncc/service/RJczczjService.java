package com.ssx.eam2ncc.service;

import com.ssx.eam2ncc.entity.RJczczj;

import java.util.List;

/**
 * 资产增加推送(RJczczj)表服务接口
 *
 * @author makejava
 * @since 2022-01-01 14:32:22
 */
public interface RJczczjService {

    List<RJczczj> queryByZcbm(String[] zcbmList);

    List<RJczczj> queryByYwid(String ywid);

    int updateByZcbm(String[] zcbmList);

    int updateByYwid(String ywid);

}
