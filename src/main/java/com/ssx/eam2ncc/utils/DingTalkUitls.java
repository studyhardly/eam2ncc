package com.ssx.eam2ncc.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DingTalkUitls {
    // 资产管理钉钉应用相关信息
    private static String APPKEY = "dingp3bipsx2vdjlhqdi";
    private static String APPSECRET = "jFNDo9LKI0Z5Z_fS5B_jOMsOENZSHvAIQq8_SxrVl4h_hF6f_WjhBQ1PfNpwJTs4";
    private static Long AGENT_ID = 513085125L;
    private static Map<String, String> map = new HashMap<>(16);




    public static void main(String[] args) throws Exception {
        updateDbMes("851143", "recorda42a3d820cdc4ff0751dc89af8e44137");// 可以使用bizId
        String res = getUserDbList("851143",0L,50L,0L);

    }


    /**
     * 发送钉钉代办消息
     *
     * @param userId           任务的执行人userid
     * @param createTime       待办时间，Unix时间戳。
     * @param title            待办任务的标题，最多50个字符。
     * @param url              待办任务的跳转链接。当链接是某个微应用链接时，希望在PC端工作台打开，可通过消息链接在PC端侧边栏打开实现。
     * @param pcUrl            PC端跳转URL，不传则使用URL参数。
     * @param originatorUserId 发起人的userid。
     * @param sourceName       待办来源名称。该名称会显示在待办的“来源”位置。
     * @param pcOpenType       待办的PC打开方式: 2：在PC端打开 4：在浏览器打开
     * @param bizId            外部业务ID，建议带上业务方来源字段，防止与其他业务方冲突。
     * @param formItemList     表单列表。 title：表单标题 ，content：内容
     * @return
     * @throws Exception
     */
    public static String sendDbMes(String userId,
                                   Long createTime,
                                   String title,
                                   String url,
                                   String pcUrl,
                                   String originatorUserId,
                                   String sourceName,
                                   Long pcOpenType,
                                   String bizId,
                                   List<OapiWorkrecordAddRequest.FormItemVo> formItemList) throws Exception {
        String access_token = getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/workrecord/add");
        OapiWorkrecordAddRequest req = new OapiWorkrecordAddRequest();
        req.setUserid(userId);
        req.setCreateTime(createTime);
        req.setTitle(title);
        req.setUrl(url);
        req.setPcUrl(pcUrl);
        req.setOriginatorUserId(originatorUserId);
        req.setSourceName(sourceName);
        req.setPcOpenType(pcOpenType);
        req.setBizId(bizId);
        req.setFormItemList(formItemList);
        OapiWorkrecordAddResponse rsp = client.execute(req, access_token);
        System.out.println(rsp.getBody());
        return rsp.getBody();
    }


    /**
     * 更新代办消息
     *
     * @param userId   任务执行人的userid（用户工号）
     * @param recordId 待办任务唯一ID。该ID可以使用发起待办中传入的biz_id，也可以使用发起待办返回结果中的record_id。
     * @throws Exception
     */
    public static String updateDbMes(String userId, String recordId) throws Exception {
        String access_token = getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/workrecord/update");
        OapiWorkrecordUpdateRequest req = new OapiWorkrecordUpdateRequest();
        req.setUserid(userId);
        req.setRecordId(recordId);
        OapiWorkrecordUpdateResponse rsp = client.execute(req, access_token);
        System.out.println(rsp.getBody());
        return rsp.getBody();

    }


    /**
     * 查询企业下用户代办列表
     * @param userId 要查询的用户userid。
     * @param offset 分页游标，从0开始，如返回结果中has_more为true，则表示还有数据，offset再传上一次的offset+limit。
     * @param limit  分页大小，最多50。
     * @param status 待办任务状态： 0：未完成  1：完成
     * @return
     * @throws Exception
     */
    public static String getUserDbList(String userId, Long offset, Long limit, Long status) throws Exception {
        String access_token = getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/workrecord/getbyuserid");
        OapiWorkrecordGetbyuseridRequest req = new OapiWorkrecordGetbyuseridRequest();
        req.setUserid(userId);
        req.setOffset(offset);
        req.setLimit(limit);
        req.setStatus(status);
        OapiWorkrecordGetbyuseridResponse rsp = client.execute(req, access_token);
        System.out.println(rsp.getBody());
        return rsp.getBody();
    }


    /**
     * 根据手机号码发送工作消息
     *
     * @param mobile
     * @param content
     */
    public static void sendMsgByMobile(String mobile, String content) {
        try {
            String accessToken = getAccessToken();
            if (map == null) {
                initUserList(accessToken);
            }
            int userListCount = getUserListCount(accessToken);
            if (userListCount > map.size()) {
                initUserList(accessToken);
            }
            senWorkMsg(accessToken, map.get(mobile), content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据userid发送钉钉消息
     *
     * @throws ApiException
     * @throws Exception
     */
    public static String sendWorkMessage(String userList, String content) throws ApiException, Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");

        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        //传入的是员工的工号
        request.setUseridList(userList);
        //申请的应用AgentId
        request.setAgentId(AGENT_ID);
        //true为全体员工
        request.setToAllUser(false);

        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype("text");
        msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
        msg.getText().setContent(content);
        request.setMsg(msg);

        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request, getAccessToken());
        return response.getBody();
    }

    /**
     * 发送图片
     *
     * @param userList
     * @param mediaId  媒体文件id，通过上传文件接口（文档最后）获得，返回的media_id可重复一直使用，请妥善保管
     * @throws Exception
     */
    public static String sendImage(String userList, String mediaId) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");

        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        //传入的是员工的工号
        request.setUseridList(userList);
        //申请的应用AgentId
        request.setAgentId(AGENT_ID);
        //true为全体员工
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype("image");
        msg.setImage(new OapiMessageCorpconversationAsyncsendV2Request.Image());
        msg.getImage().setMediaId(mediaId);
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request, getAccessToken());
        return response.getBody();
    }


    /**
     * 发送文件
     *
     * @param userList
     * @param mediaId
     */
    public static String sendFile(String userList, String mediaId) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        //传入的是员工的工号
        request.setUseridList(userList);
        //申请的应用AgentId
        request.setAgentId(AGENT_ID);
        //true为全体员工
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        //发送文件
        msg.setMsgtype("file");
        msg.setFile(new OapiMessageCorpconversationAsyncsendV2Request.File());
        msg.getFile().setMediaId(mediaId);
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request, getAccessToken());
        return response.getBody();
    }

    /**
     * 发送链接
     *
     * @param userList   员工id，多人员中间用 “，” 隔开
     * @param title      标题
     * @param text       文本
     * @param messageUrl 消息链接
     * @param picUrl     图片链接
     * @throws Exception
     */
    public static String sendLink(String userList, String title, String text, String messageUrl, String picUrl) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        //传入的是员工的工号
        request.setUseridList(userList);
        //申请的应用AgentId
        request.setAgentId(AGENT_ID);
        //true为全体员工
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype("link");
        msg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
        msg.getLink().setTitle(title);
        msg.getLink().setText(text);
        msg.getLink().setMessageUrl(messageUrl);
        msg.getLink().setPicUrl(picUrl);
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request, getAccessToken());
        return response.getBody();
    }

    /**
     * 发送markDown消息
     *
     * @param userList 用户id，多用户之间用 “，”分割
     * @param title    标题
     * @param content  md格式内容
     */
    public static String sendMarkDownMsg(String userList, String title, String content) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        //传入的是员工的工号
        request.setUseridList(userList);
        //申请的应用AgentId
        request.setAgentId(AGENT_ID);
        //true为全体员工
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        //发送链接
        msg.setMsgtype("markdown");
        msg.setMarkdown(new OapiMessageCorpconversationAsyncsendV2Request.Markdown());
        msg.getMarkdown().setText(content);
        msg.getMarkdown().setTitle(title);
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request, getAccessToken());
        return response.getBody();
    }


    /**
     * 发送应用内消息
     *
     * @param userList 用户id，多用户之间用 “，”分割
     * @param content  内容
     * @throws Exception
     */
    public static String sendOAMsg(String userList, String content) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        //传入的是员工的工号
        request.setUseridList(userList);
        //申请的应用AgentId
        request.setAgentId(AGENT_ID);
        //true为全体员工
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
        msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
        //msg.getOa().getHead().setText(head);
        msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
        msg.getOa().getBody().setContent(content);
        msg.setMsgtype("oa");
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request, getAccessToken());
        return response.getBody();
    }

    /**
     * 发送文本信息+url
     *
     * @param userList  用户id，多用户之间用 “，”分割
     * @param title     标题
     * @param mdContent 内容
     * @param sTitle
     * @param sUrl      url
     * @throws Exception
     */
    public static String sendTextWithLink(String userList, String title, String mdContent, String sTitle, String sUrl) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        //传入的是员工的工号
        request.setUseridList(userList);
        //申请的应用AgentId
        request.setAgentId(AGENT_ID);
        //true为全体员工
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();

        //发送的文本信息+url
        msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
        msg.getActionCard().setTitle(title);
        msg.getActionCard().setMarkdown(mdContent);
        msg.getActionCard().setSingleTitle(sTitle);
        msg.getActionCard().setSingleUrl(sUrl);
        msg.setMsgtype("action_card");
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request, getAccessToken());
        return response.getBody();
    }

    /**
     * 获取 accessToken
     *
     * @return
     * @throws Exception
     */
    private static String getAccessToken() throws Exception {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();

        request.setAppkey(APPKEY);
        request.setAppsecret(APPSECRET);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        String accessToken = response.getAccessToken();
        return accessToken;
    }


    /**
     * 发送工作消息
     *
     * @param accessToken
     * @param userId
     * @param content
     * @throws Exception
     */
    private static String senWorkMsg(String accessToken, String userId, String content) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        request.setUseridList(userId);
        request.setAgentId(AGENT_ID);
        request.setToAllUser(false);
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
        msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
        msg.getOa().getHead().setText("head");
        msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
        msg.getOa().getBody().setContent(content);
        msg.setMsgtype("oa");
        request.setMsg(msg);
        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request, accessToken);
        return response.getBody();

    }

    /**
     * 部门用户列表
     *
     * @param accessToken
     * @throws Exception
     */
    private static void initUserList(String accessToken) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/simplelist");
        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
        request.setDepartmentId(1L);
        request.setOffset(0L);
        request.setSize(10L);
        request.setHttpMethod("GET");
        OapiUserSimplelistResponse response = client.execute(request, accessToken);
        List<OapiUserSimplelistResponse.Userlist> userlist = response.getUserlist();
        for (OapiUserSimplelistResponse.Userlist user : userlist) {
            String userId = user.getUserid();
            String mobile = getMobile(accessToken, userId);
            map.put(mobile, userId);
        }
    }

    /**
     * 获取部门用户数量
     *
     * @param accessToken
     * @return
     * @throws Exception
     */
    private static int getUserListCount(String accessToken) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/simplelist");
        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
        request.setDepartmentId(1L);
        request.setOffset(0L);
        request.setSize(10L);
        request.setHttpMethod("GET");
        OapiUserSimplelistResponse response = client.execute(request, accessToken);
        List<OapiUserSimplelistResponse.Userlist> userlist = response.getUserlist();
        return userlist.size();
    }

    /**
     * 根据 userId 获取手机号
     *
     * @param accessToken
     * @param userId
     * @return
     * @throws Exception
     */
    private static String getMobile(String accessToken, String userId) throws Exception {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get");
        OapiUserGetRequest request = new OapiUserGetRequest();
        request.setUserid(userId);
        request.setHttpMethod("GET");
        OapiUserGetResponse response = client.execute(request, accessToken);
        return response.getMobile();
    }

}
