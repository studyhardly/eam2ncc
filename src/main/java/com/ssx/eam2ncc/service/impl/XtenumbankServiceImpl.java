package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.entity.Xtenumbank;
import com.ssx.eam2ncc.dao.XtenumbankDao;
import com.ssx.eam2ncc.service.XtenumbankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 枚举以及枚举项表(Xtenumbank)表服务实现类
 *
 * @author makejava
 * @since 2022-01-05 15:39:15
 */
@Service("xtenumbankService")
public class XtenumbankServiceImpl implements XtenumbankService {
    @Resource
    private XtenumbankDao xtenumbankDao;

    /**
     *
     *
     * @return
     */
    @Override
    public List<Xtenumbank> query(String enumlxid,String enumlxmc,String enumvalue ) {
        return this.xtenumbankDao.query(enumlxid,enumlxmc,enumvalue);
    }

}
