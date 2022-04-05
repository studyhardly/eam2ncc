package com.ssx.eam2ncc.service.impl;

import com.dingtalk.api.request.OapiWorkrecordAddRequest;
import com.ssx.eam2ncc.service.IDingTalkService;
import com.ssx.eam2ncc.utils.DingTalkUitls;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("dingTalkService")
public class DingTalkServiceImpl implements IDingTalkService {

    /**
     * 发送钉钉消息通知
     *
     * @param userId  消息接收人userid （工号）
     * @param content 消息内容
     * @return
     */
    @Override
    public String sendWorkMessage(String userId, String content) throws Exception {
        return DingTalkUitls.sendWorkMessage(userId, content);
    }

    /**
     * 发送钉钉代办消息
     */
    @Override
    public String sendDbMessage() throws Exception {
        String userId = "851143";
        Long createTime = System.currentTimeMillis() / 1000;
        String title = "资产管理系统代办";
        String url = "http://61.178.136.164:9081/#/login?orgId=010B&userId=107166&name=动火安全作业证&billid=992&owner=马培林&stateCode=0&time=2022-03-08&classId=gris.ywdj&typeId=194&BizID=240609&processInstId=213180&workItemId=724554";
        String pcUrl ="dingtalk://dingtalkclient/page/link?pc_silde=false&url=http%3A%2F%2Feam.jnmc.com%2FYGFMISWeb%2Ffaces%2FAutoLoginServlet%3FsystemId%3DDDThirduserAdapter%26pc_message_url%3D%2525252Fgrm%2525252Fcore.workflow.engine%2525252Fworkflow%2525252Ftodo.html%2525253FBizID%2525253D240609%25252526processDefID%2525253D1902%25252526activityDefID%2525253DecpUserTask1%25252526classId%2525253Dgris.ywdj%25252526typeId%2525253D194%25252526processInstId%2525253D213180%25252526activityInstID%2525253D1428288%25252526startDwdh%2525253D010B%25252526workItemId%2525253D724554%25252526openmode%2525253D1%25252526processtype%2525253D2%25252526webProxy%2525253Dtrue%25252526ecpIframeModel%2525253Dtrue%25252526allRedirect%2525253Dgris.ywdj_otAclbdh%26yhdm%3D117377";
        String originatorUserId = "851143";
        String sourceName = "资产管理系统";
        Long pcOpenType = 2L;
        String bizId = "123456";
        List<OapiWorkrecordAddRequest.FormItemVo> formItemList = new ArrayList<>();
        Map<String, String> formItems = new HashMap<>();
        formItems.put("单据编码","992");
        formItems.put("上一环节处理人","851143");
        formItems.put("创建人","851143");
        formItems.put("创建时间","2022-03-08");
        Iterator<String> iter = formItems.keySet().iterator();
        while(iter.hasNext()){
            OapiWorkrecordAddRequest.FormItemVo object = new OapiWorkrecordAddRequest.FormItemVo();
            String key=iter.next();
            String value = formItems.get(key);
            System.out.println(key+" "+value);
            object.setTitle(key);
            object.setContent(value);
            formItemList.add(object);
        }

        String result = DingTalkUitls.sendDbMes(userId, createTime, title, url, pcUrl, originatorUserId, sourceName, pcOpenType, bizId, formItemList);

        return result;
    }

    /**
     * 更新代办消息
     *
     * @param userId   任务执行人的userid（用户工号）
     * @param recordId 待办任务唯一ID。该ID可以使用发起待办中传入的biz_id，也可以使用发起待办返回结果中的record_id。
     * @throws Exception
     */
    @Override
    public String updateDbMessage(String userId, String recordId) throws Exception {
        return DingTalkUitls.updateDbMes(userId, recordId);
    }


    /**
     * 查询企业下用户代办列表
     *
     * @param userId 要查询的用户userid。
     * @param offset 分页游标，从0开始，如返回结果中has_more为true，则表示还有数据，offset再传上一次的offset+limit。
     * @param limit  分页大小，最多50。
     * @param status 待办任务状态： 0：未完成  1：完成
     * @return
     * @throws Exception
     */
    @Override
    public String getUserDbList(String userId, Long offset, Long limit, Long status) throws Exception {
        return DingTalkUitls.getUserDbList(userId, offset, limit, status);
    }


}
