package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.entity.Xtclusteruser;
import com.ssx.eam2ncc.dao.XtclusteruserDao;
import com.ssx.eam2ncc.service.XtclusteruserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统集群在线用户登录信息(Xtclusteruser)表服务实现类
 *
 * @author makejava
 * @since 2021-12-29 08:17:17
 */
@Service("xtclusteruserService")
public class XtclusteruserServiceImpl implements XtclusteruserService {
    @Resource
    private XtclusteruserDao xtclusteruserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param logid
     * @return 实例对象
     */
    @Override
    public List<Xtclusteruser> queryById(String username ,String logid) {
        return this.xtclusteruserDao.queryById(username ,logid);
    }

    /**
     * @return
     */
    @Override
    public List<Xtclusteruser> queryAll() {
        return this.xtclusteruserDao.queryAll();
    }

    /**
     * 通过主键删除数据
     *
     * @param logid
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String logid) {
        return this.xtclusteruserDao.deleteById(logid) > 0;
    }

    /**
     * 清除锁定用户
     */
    @Override
    public String  clearLockUser() {
        if(this.xtclusteruserDao.clearLockUser()>0){
            return  "所有锁定用户已解锁！";
        }

        return "当前无锁定用户，无需解锁 ！";

    }
}
