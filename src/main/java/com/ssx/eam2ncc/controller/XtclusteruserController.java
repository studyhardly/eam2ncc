package com.ssx.eam2ncc.controller;

import com.ssx.eam2ncc.entity.Xtclusteruser;
import com.ssx.eam2ncc.service.XtclusteruserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统集群在线用户登录信息(Xtclusteruser)表控制层
 *
 * @author makejava
 * @since 2021-12-29 08:17:15
 */
@RestController
@RequestMapping("user")
@Slf4j
public class XtclusteruserController {
    /**
     * 服务对象
     */
    @Resource
    private XtclusteruserService xtclusteruserService;

    /**
     * @return
     */
    @PostMapping("all")
    public List<Xtclusteruser> queryAll() {
        return (this.xtclusteruserService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @PostMapping("queryUser")
    public List<Xtclusteruser> queryById(@Param("username") String username,@Param("logid") String logid) {

        log.info("username:{}",username);
        log.info("logid:{}",logid);
        return this.xtclusteruserService.queryById(username ,logid);
    }


    /**
     * 删除数据
     *
     * @param logid 主键
     * @return 删除是否成功
     */
    @PostMapping("clear")
    public ResponseEntity<Boolean> deleteById(@Param("logid") String logid) {
        return ResponseEntity.ok(this.xtclusteruserService.deleteById(logid));
    }

    @PostMapping("clearlock")
    public String clearLockUserClas(){
        return this.xtclusteruserService.clearLockUser();

    }

}

