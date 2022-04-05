package com.ssx.eam2ncc.utils;

import cn.hutool.json.JSONObject;
import com.ssx.eam2ncc.api.HutoolUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendDingDingMessage {

    /**
     * 发送钉钉消息
     * @param userCode
     * @param content
     */
    public  static String sendToDingDingMessage(String userCode, String content) {
        log.info("调用接口发送钉钉消息");
        String url = "http://gxcx.jnmc.com:8888/sendTextMsg";
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("userList", userCode);
        jsonObject.putOpt("content", content);
        jsonObject.putOpt("title", "同步NCC成功");
        return HutoolUtils.doPost(url, jsonObject);
    }
}
