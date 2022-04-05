package com.ssx.eam2ncc.service;

import com.dingtalk.api.request.OapiWorkrecordAddRequest;

import java.util.List;

public interface IDingTalkService {

    /**
     * 发送钉钉消息通知
     * @param userId 消息接收人userid （工号）
     * @param content 消息内容
     * @return
     */
    String sendWorkMessage(String userId ,String content) throws Exception;

    /**
     * 发送钉钉代办消息
     */
    String sendDbMessage() throws Exception;

    /**
     * 更新代办消息
     *
     * @param userId   任务执行人的userid（用户工号）
     * @param recordId 待办任务唯一ID。该ID可以使用发起待办中传入的biz_id，也可以使用发起待办返回结果中的record_id。
     * @throws Exception
     */
    String updateDbMessage(String userId, String recordId) throws Exception;

    /**
     * 查询企业下用户代办列表
     * @param userId 要查询的用户userid。
     * @param offset 分页游标，从0开始，如返回结果中has_more为true，则表示还有数据，offset再传上一次的offset+limit。
     * @param limit  分页大小，最多50。
     * @param status 待办任务状态： 0：未完成  1：完成
     * @return
     * @throws Exception
     */
    String getUserDbList(String userId, Long offset, Long limit, Long status) throws Exception;
}
