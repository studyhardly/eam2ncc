package com.ssx.eam2ncc.utils;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserSimplelistRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserSimplelistResponse;
import com.taobao.api.ApiException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SendDingDingMesUtil {
    // 资产管理钉钉应用相关信息
    private static String APPKEY = "dingp3bipsx2vdjlhqdi";
    private static String APPSECRET = "jFNDo9LKI0Z5Z_fS5B_jOMsOENZSHvAIQq8_SxrVl4h_hF6f_WjhBQ1PfNpwJTs4";
    private static Long AGENT_ID = 513085125L;
    private static Map<String, String> map = new HashMap<>(16);

    public static void main(String[] args) throws Exception {
        // SendDingTalkMsgByUserId("851143", "测试发送钉钉消息");
        //  sendMarkDownMsg("851143","警告","## 志哥，请勿在上班期间摸鱼");

        // sendOAMsg("851143","你是一个好人");
        //sendM
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
    public static void SendDingTalkMsgByUserId(String userList, String content) throws ApiException, Exception {
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
    }

    /**
     * 发送图片
     *
     * @param userList
     * @param mediaId  媒体文件id，通过上传文件接口（文档最后）获得，返回的media_id可重复一直使用，请妥善保管
     * @throws Exception
     */
    public static void sendImage(String userList, String mediaId) throws Exception {
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
    }


    /**
     * 发送文件
     *
     * @param userList
     * @param mediaId
     */
    public void sendFile(String userList, String mediaId) throws Exception {
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
    public void sendLink(String userList, String title, String text, String messageUrl, String picUrl) throws Exception {
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
    }

    /**
     * 发送markDown消息
     *
     * @param userList 用户id，多用户之间用 “，”分割
     * @param title    标题
     * @param content  md格式内容
     */
    public static void sendMarkDownMsg(String userList, String title, String content) throws Exception {
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

    }


    /**
     * 发送应用内消息
     *
     * @param userList 用户id，多用户之间用 “，”分割
     * @param content  内容
     * @throws Exception
     */
    public static void sendOAMsg(String userList, String content) throws Exception {
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
    public void sendTextWithLink(String userList, String title, String mdContent, String sTitle, String sUrl) throws Exception {
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
    private static void senWorkMsg(String accessToken, String userId, String content) throws Exception {
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
