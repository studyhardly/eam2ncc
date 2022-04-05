package com.ssx.eam2ncc.dao;

import com.ssx.eam2ncc.entity.EamXtywUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (EamXtywUser)表数据库访问层
 *
 * @author youth
 * @since 2022-02-15 10:15:28
 */
@Repository("eamXtywUserDao")
public interface EamXtywUserDao {


    /**
     * 通过ID查询单条数据
     *
     * @param usercode 主键
     * @return 实例对象
     */
    EamXtywUser selectById(@Param("usercode")String usercode);
    /**
     * 通过ID查询数据
     *
     * @param usercode 主键
     * @return 实例对象
     */
    List<EamXtywUser> queryById(@Param("usercode")String usercode,@Param("username")String username);
    /**
     * 通过查询所有数据
     *
     * @return 实例对象
     */
    List<EamXtywUser> queryAll();
    /**
     * 查询激活的用户
     *
     * @return 实例对象
     */
    List<EamXtywUser> queryReal();
    /**
     * 新增运维人员
     * @return
     */
    int addUser(@Param("user") EamXtywUser user);
    /**
     * 修改运维人员
     * @return
     */
    int updateUser(@Param("user") EamXtywUser user);
    /**
     * 新增多个运维人员
     * @return
     */
    int addUsers(@Param("users") List<EamXtywUser> users);
    /**
     * 上线运维人员
     * @return
     */
    int onlineUsers(@Param("usercode")String usercode);
    /**
     * 下线运维人员
     * @return
     */
    int clearUsers(@Param("usercode")String usercode);
    /**clearUsers
     * 删除多个运维人员
     * @return
     */
    int deleteUsers(String[] ids);
    /**
     * 批量修改运维人员
     * @return
     */
    int updateUsers(List<EamXtywUser> users);
}

