package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.entity.RJczczj;
import com.ssx.eam2ncc.dao.RJczczjDao;
import com.ssx.eam2ncc.service.RJczczjService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 资产增加推送(RJczczj)表服务实现类
 *
 * @author makejava
 * @since 2022-01-01 14:32:22
 */
@Service("rJczczjService")
public class RJczczjServiceImpl implements RJczczjService {
    @Resource
    private RJczczjDao rJczczjDao;


    @Override
    public List<RJczczj> queryByZcbm(String[] zcbmList) {
        return rJczczjDao.queryByZcbm(zcbmList);
    }

    @Override
    public List<RJczczj> queryByYwid(String ywid) {
        return rJczczjDao.queryByYwid(ywid);
    }

    @Override
    public int updateByZcbm(String[] zcbmList) {
        return rJczczjDao.updateByZcbm(zcbmList);
    }

    @Override
    public int updateByYwid(String ywid) {
        return rJczczjDao.updateByYwid(ywid);
    }
}
