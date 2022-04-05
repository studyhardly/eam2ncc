package com.ssx.eam2ncc.service;

import com.ssx.eam2ncc.entity.EamXtywUser;

import java.util.List;
public interface EamXtywUserService {

    /**
     * 通过ID查询单条数据
     * @return
     */
    EamXtywUser selectById(String usercode);
    /**
     * 通过ID,name查询数据
     * @return
     */
    List<EamXtywUser> queryById(String usercode,String username);
    /**
     * 查询所有运维人员
     * @return
     */
    List<EamXtywUser> queryAll();
    /**
     * 查询激活用户
     * @return
     */
    List<EamXtywUser> queryReal();
    /**
     * 新增运维人员
     * @return
     */
    int addUser(EamXtywUser user) throws Exception;
    /**
     * 新增多个运维人员
     * @return
     */
    int addUsers(List<EamXtywUser> users) throws Exception;
    /**
     * 上线运维人员
     * @return
     */
    int onlineUsers(String id);
    /**
     * 下线运维人员
     * @return
     */
    int clearUsers(String id);
    /**
     * 删除单个运维人员
     * @return
     */
    int deleteUser(String id);
    /**
     * 删除多个运维人员
     * @return
     */
    int deleteUsers(String[] ids);
    /**
     * 修改单个运维人员
     * @return
     */
    int updateUser(EamXtywUser user);
    /**
     * 批量修改运维人员
     * @return
     */
    int updateUsers(List<EamXtywUser> users);
}
