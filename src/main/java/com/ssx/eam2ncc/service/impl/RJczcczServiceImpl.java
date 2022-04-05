package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.entity.RJczccz;
import com.ssx.eam2ncc.dao.RJczcczDao;
import com.ssx.eam2ncc.service.RJczcczService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资产处置推送(RJczccz)表服务实现类
 *
 * @author makejava
 * @since 2022-01-04 16:48:22
 */
@Service("rJczcczService")
public class RJczcczServiceImpl implements RJczcczService {
    @Resource
    private RJczcczDao rJczcczDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    @Override
    public List<RJczccz> queryById(String tid) {
        return this.rJczcczDao.queryById(tid);
    }

}
