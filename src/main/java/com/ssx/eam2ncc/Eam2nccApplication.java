package com.ssx.eam2ncc;


import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssx.eam2ncc.dao")
public class Eam2nccApplication {

    public static void main(String[] args)  {
        SpringApplication.run(Eam2nccApplication.class, args);

        //开启定时任务
        CronUtil.start(true);


    }


}
