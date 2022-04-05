package com.ssx.eam2ncc.api;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HutoolUtils {


    /**
     * 调用接口发送http请求
     *
     * @param url  接口地址
     * @param json 参数
     * @return
     */
    public static String doPost(String url, JSONObject json) {
        /*发送post请求并接收响应数据
            header对应的是请求头
            body对应的是请求体(包含参数和参数值)。
            HttpRequest里面包含Post、GET、Delete、Put等常用的RestFul方式。
         */
        String post = HttpRequest.post(url)
                .header("Content-Type", "application/json;charset=utf-8")
                .body(String.valueOf(json))
                .execute().body();
        return post;
    }

}

