package com.ssx.eam2ncc.service.impl;

import cn.hutool.json.JSONObject;
import com.ssx.eam2ncc.api.HutoolUtils;
import com.ssx.eam2ncc.entity.EamXtywUser;
import com.ssx.eam2ncc.entity.MonitorTJczczj;
import com.ssx.eam2ncc.dao.MonitorTJczczjDao;
import com.ssx.eam2ncc.entity.Xtywbill;
import com.ssx.eam2ncc.service.EamXtywUserService;
import com.ssx.eam2ncc.service.MonitorTJczczjService;
import com.ssx.eam2ncc.service.XtywbillService;
import com.ssx.eam2ncc.utils.SendDingDingMesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * (MonitorTJczczj)表服务实现类
 *
 * @author youth
 * @since 2022-02-14 09:33:08
 */
@Service("monitorTJczczjService")
@Slf4j
public class MonitorTJczczjServiceImpl implements MonitorTJczczjService {
    @Resource
    private MonitorTJczczjDao monitorTJczczjDao;

    @Resource
    private XtywbillService xtywbillService;

    @Resource
    private EamXtywUserService eamXtywUserService;


    /**
     * 根据标识flag查询数据
     *
     * @param
     * @return
     */
    @Override
    public String sendDingDingMessage() throws  Exception{
        List<MonitorTJczczj> list = monitorTJczczjDao.queryByFlag(1);
        List<String> ywids = new ArrayList<String>();
        List<MonitorTJczczj> successList = null;
        List<MonitorTJczczj> failedList = null;
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String ywid = list.get(i).getPosummary();
                if (!ywids.contains(ywid)) {
                    ywids.add(ywid);
                }
            }
        }
        for (int i = 0; i < ywids.size(); i++) {
            StringBuffer successMsg = new StringBuffer();
            StringBuffer failedMsg = new StringBuffer();
            //查成功的
            successList = monitorTJczczjDao.queryByYwidAndStatus(ywids.get(i), 0);
            //成功的
            if (successList.size() > 0) {
                Integer gid = Integer.parseInt(successList.get(0).getPosummary());
                //发成功消息
                Xtywbill xtdj = xtywbillService.getBillInfoByGid(gid);
                String billid = xtdj.getBillid().toString();
                //查制单人
                String createUserCode = this.getCreateUer(xtdj);
                successMsg.append("资产转固单据:").append(billid).append("\n");
                for (int j = 0; j < successList.size(); j++) {
                    successMsg.append("资产编码：").append(successList.get(j).getTid()).append("\n");
                    // 回写最新状态
                    this.updateFlagByTid(successList.get(j).getTid(),0);

                }
                successMsg.append("同步NCC系统成功\n");
                //发送成功消息
                log.info("资产增加推送成功消息：{}",successMsg);

                StringBuffer userList = new StringBuffer();
                //校验制单人不为空则通知制单人
                if(createUserCode!= null){
                    userList.append(createUserCode).append(",");
                }
                //组装消息接收人
                userList.append(this.xtywUserList());
                log.info("消息接受人员，{}",userList);
              //  sendToDingDingMessage(userList.toString(), successMsg.toString());
                SendDingDingMesUtil.SendDingTalkMsgByUserId(userList.toString(),successMsg.toString());
            }


            //查失败的
            failedList = monitorTJczczjDao.queryByYwidAndStatus(ywids.get(i), 1);
            if (failedList.size() > 0) {
                //查单据编码
                Integer gid = Integer.parseInt(failedList.get(0).getPosummary());
                //发成功消息
                Xtywbill xtdj = xtywbillService.getBillInfoByGid(gid);
                //查制单人
                String createUserCode = this.getCreateUer(xtdj);
                String billid  = xtywbillService.getBillInfoByGid(Integer.parseInt(failedList.get(0).getPosummary())).getBillid().toString();
               // String billid =  failedList.get(0).getPosummary();
                failedMsg.append("资产转固单据:").append(billid).append("\n");
                for (int k = 0; k < failedList.size(); k++) {
                    failedMsg.append("资产编码：").append(failedList.get(k).getTid()).append("\n同步NCC系统失败\n失败原因: \n").append(failedList.get(k).getSysncmessage()).append(" ;\n");
                   // 回写最新状态
                    this.updateFlagByTid(failedList.get(k).getTid(),0);
                }
                failedMsg.append("请联系运维人员处理！");
                log.info("资产增加推送失败消息：{}",failedMsg);
                //发送钉钉通知
                StringBuffer userList = new StringBuffer();
                //校验制单人不为空则通知制单人
                if(createUserCode!= null){
                    userList.append(createUserCode).append(",");
                }
                //组装消息接收人
                userList.append(this.xtywUserList());
                log.info("失败消息接受人员:{}",userList);
              //  sendToDingDingMessage(userList.toString(), failedMsg.toString());
                SendDingDingMesUtil.SendDingTalkMsgByUserId(userList.toString(),failedMsg.toString());
            }
            return "资产增加集成结果推送钉钉消息完成！";
        }
        return "当前无资产增加集成记录，无需推送钉钉消息！";
    }


    /**
     * 根据tid修改标识falg
     *
     * @param tid   主键id
     * @param isNew 最新标识
     * @return
     */
    @Override
    public Integer updateFlagByTid(String tid, Integer isNew) {
        return monitorTJczczjDao.updateFlagByTid(tid,isNew);
    }

    /**
     * 发送钉钉消息
     * @param userCode
     * @param content
     */
    private   String sendToDingDingMessage(String userCode, String content) {
        log.info("调用接口发送钉钉消息");
        String url = "http://gxcx.jnmc.com:8888/sendTextMsg";
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("userList", userCode);
        jsonObject.putOpt("content", content);
        return HutoolUtils.doPost(url, jsonObject);
    }

    private  String getCreateUer(Xtywbill xtdj) throws  Exception{
        //查询制单人
        String typeid = xtdj.getTypeid();
        String ywdj = "XT"+typeid+"YWBILL";
        log.info("业务单据；{}",ywdj);
        String createUserCode = xtywbillService.getCreateUserCode(xtdj.getGid(),ywdj,"tbr");
        log.info("制单人：{}",createUserCode);
        //校验用户是否为正式职工
        if(createUserCode.length()!=6){
            return null ;
        }
        return createUserCode;
    }

    private String xtywUserList(){
        //运维人员
        List<EamXtywUser> ywUser = eamXtywUserService.queryAll();
        StringBuffer sb = new StringBuffer();
        if (ywUser.size()>0) {
            for (int i = 0; i <ywUser.size(); i++) {
               sb.append( ywUser.get(i).getUsercode()).append(",");
            }
        }
        return sb.toString();
    }
}
