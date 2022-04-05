package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.dao.EamXtywUserDao;
import com.ssx.eam2ncc.entity.EamXtywUser;
import com.ssx.eam2ncc.service.EamXtywUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service("eamXtywUserService")
public class EamXtywUserServiceImpl implements EamXtywUserService {
    @Resource
    private EamXtywUserDao eamXtywUserDao;

    @Override
    public EamXtywUser selectById(String usercode) {
        return eamXtywUserDao.selectById(usercode);
    }
    @Override
    public List<EamXtywUser> queryById(String usercode, String username) {
        return eamXtywUserDao.queryById(usercode,username);
    }


    /**
     * 查询所有运维人员
     *
     * @return
     */
    @Override
    public List<EamXtywUser> queryAll() {
        return eamXtywUserDao.queryAll();
    }
    /**
     * 查询激活用户
     *
     * @return
     */
    @Override
    public List<EamXtywUser> queryReal() {
        return eamXtywUserDao.queryReal();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//写Exception.class也可以
    public int addUser(EamXtywUser user) {
        int i=eamXtywUserDao.addUser(user);
        if(i<1) {
            //故障
            throw new RuntimeException("发生异常了..");
        }
        return i;
    }

    @Override
    public int updateUser(EamXtywUser user) {
        int i=eamXtywUserDao.updateUser(user);
        if(i<1) {
            //故障
            throw new RuntimeException("发生异常了..");
        }
        return i;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)//写Exception.class也可以
    public int addUsers(List<EamXtywUser> users) throws Exception{
        int i = eamXtywUserDao.addUsers(users);
        if(i<1) {
            //故障
            throw new RuntimeException("发生异常了..");
        }
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//写Exception.class也可以
    public int onlineUsers(String id) {
        int i=0;
        i=eamXtywUserDao.onlineUsers(id);
        if(i<1) {
            //故障
            throw new RuntimeException("发生异常了..");
        }
        return i;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)//写Exception.class也可以
    public int clearUsers(String id) {
        int i=0;
        i=eamXtywUserDao.clearUsers(id);
        if(i<1) {
            //故障
            throw new RuntimeException("发生异常了..");
        }
        return i;
    }

    @Override
    public int deleteUser(String id) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//写Exception.class也可以
    public int deleteUsers(String[] ids) {
        int i=0;
        i=eamXtywUserDao.deleteUsers(ids);
        if(i<1) {
            //故障
            throw new RuntimeException("发生异常了..");
        }
        return i;
    }




    @Override
    @Transactional(rollbackFor = Exception.class)//写Exception.class也可以
    public int updateUsers(List<EamXtywUser> users) {
        int i=0;
        i = eamXtywUserDao.updateUsers(users);

        return i;
    }


}
