package com.ssx.eam2ncc.daoTest;

import com.ssx.eam2ncc.dao.RJczcsbbdDao;
import com.ssx.eam2ncc.entity.RJczcsbbd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ZcsbbdDaoTests {

    @Resource
    private RJczcsbbdDao jczcsbbdDao;

    @Test
    public void getInfo(){
        String ywid = "225544";
        RJczcsbbd res = jczcsbbdDao.queryById(ywid);
        System.out.println(res);
    }
}
