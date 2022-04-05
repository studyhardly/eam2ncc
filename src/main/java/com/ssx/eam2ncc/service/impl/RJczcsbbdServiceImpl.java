package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.entity.RJczcsbbd;
import com.ssx.eam2ncc.dao.RJczcsbbdDao;
import com.ssx.eam2ncc.service.RJczcsbbdService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 资产设备变动集成(RJczcsbbd)表服务实现类
 *
 * @author youth
 * @since 2022-02-10 15:03:10
 */
@Service("rJczcsbbdService")
public class RJczcsbbdServiceImpl implements RJczcsbbdService {
    @Resource
    private RJczcsbbdDao rJczcsbbdDao;

    @Override
    public RJczcsbbd getResult(String ywid) {
        return rJczcsbbdDao.queryById(ywid);
    }
}
