package com.ssx.eam2ncc.test;

import cn.hutool.json.JSONObject;
import com.ssx.eam2ncc.api.HutoolUtils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class DingDingMesTest {

    @Test
    public  void sendMes(){
        String url = "http://gxcx.jnmc.com:8888/sendTextMsg";
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("userList","851143");
        jsonObject.putOpt("content","123455");
        HutoolUtils.doPost(url,jsonObject);

    }

}
