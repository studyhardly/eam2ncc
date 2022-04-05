package com.ssx.eam2ncc.serviceTest;

import com.ssx.eam2ncc.entity.EamXtywUser;
import com.ssx.eam2ncc.service.EamXtywUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EamXtywUserServiceTests {

    @Resource
    private EamXtywUserService eamXtywUserService;

    @Test
    public void getUserList(){
        List<EamXtywUser> list = eamXtywUserService.queryAll();
        System.out.println(list.toString());
    }
}
