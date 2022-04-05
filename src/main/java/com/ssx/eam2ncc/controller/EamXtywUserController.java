package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.common.CommonResult;
import com.ssx.eam2ncc.entity.EamXtywUser;
import com.ssx.eam2ncc.entity.Xtclusteruser;
import com.ssx.eam2ncc.service.EamXtywUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * (VZczjKpmx)表控制层
 *
 * @author makejava
 * @since 2021-12-27 08:30:48
 */
@RestController
@RequestMapping("sysuser")
@Slf4j
public class EamXtywUserController {
    /**
     * 服务对象
     */
    @Resource
    private EamXtywUserService eamXtywUserService;

    /**
     * @return 查询全部用户
     */
    @PostMapping("all")
    public List<EamXtywUser> queryAllUsers() throws Exception {
        log.info("查询全部用户");
        return eamXtywUserService.queryAll();
    }
    /**
     * @return 查询激活的用户
     */
    @PostMapping("/realUsers")
    @ResponseBody
    public List<EamXtywUser> queryRealUsers() throws Exception {
        log.info("查询激活的用户");
        return eamXtywUserService.queryReal();
    }
    /**
     * @return 查询用户By usercode，username
     */
    @PostMapping("queryUser")
    public List<EamXtywUser> queryById(@Param("usercode") String usercode, @Param("username") String username) {
        log.info("usercode:{}",usercode);
        log.info("username:{}",username);
        return eamXtywUserService.queryById(usercode,username);
    }
    /**
     * @return 查询用户By usercode
     */
    @PostMapping("selectById")
    public EamXtywUser selectById(@Param("usercode") String usercode) {
        log.info("usercode:{}",usercode);
        return eamXtywUserService.selectById(usercode);
    }
    /**
     * 添加用户
     *
     * @param  usercode 主键
     * @return 是否成功
     */
    @PostMapping("add")
    @ResponseBody
    public String adduser(@Param("usercode")String usercode,@Param("username")String username,@Param("remark")String remark) throws Exception {
        EamXtywUser user = new EamXtywUser(usercode,username,"0",remark);
        log.info(user.toString());
        EamXtywUser u=selectById(usercode);
        if(u==null){
            int i =eamXtywUserService.addUser(user);
            log.info("添加用户信息数：{}",i);
            if (i >= 1) {
                return "添加成功！";
            }else {
                return "添加失败！";
            }
        }else {
            return "该用户的工号已重复！";
        }
    }
    /**
     * 修改用户
     *
     * @param  usercode 主键
     * @return 是否成功
     */
    @PostMapping("edit")
    @ResponseBody
    public String edituser(@Param("usercode")String usercode,@Param("username")String username,@Param("remark")String remark) throws Exception {
        EamXtywUser user = new EamXtywUser(usercode,username,"0",remark);
        log.info(user.toString());
        int i =eamXtywUserService.updateUser(user);
        if(i<1){
            return "修改失败！";
        }else {
            return "修改成功！";
        }
    }
    /**
     * 添加多用户
     *
     * @param  addUsers 主键
     * @return 是否成功
     */
    @PostMapping("adds")
    public List<EamXtywUser> addusers(List<EamXtywUser> addUsers) throws Exception {
        if (eamXtywUserService.addUsers(addUsers) < 1) {
            return queryRealUsers();
        }
        return queryRealUsers();
    }
    /**
     * 上线用户
     *
     * @param  usercode 主键
     * @return 是否成功
     */
    @PostMapping("online")
    public int onlineUsersByid(@Param("usercode")String usercode) {
        if (eamXtywUserService.onlineUsers(usercode) < 1) {
            log.info("上线用户失败");
            return 0;
        }
        return 1;
    }
    /**
     * 下线用户
     *
     * @param  usercode 主键
     * @return 是否成功
     */
    @PostMapping("clear")
    public int clearUsersByid(@Param("usercode")String usercode) {
        if (eamXtywUserService.clearUsers(usercode) < 1) {
            log.info("下线用户失败");
            return 0;
        }
        return 1;
    }
    /**
     * 删除数据
     *
     * @param  usercode 主键
     * @return 删除是否成功
     */
    @PostMapping("del")
    public List<EamXtywUser> deleteUsersByids(@Param("usercode")String[] usercode) throws Exception {
        if (eamXtywUserService.deleteUsers(usercode) < 1) {
            log.info("删除用户失败");
            return queryRealUsers();
        }
        return queryRealUsers();
    }

}

