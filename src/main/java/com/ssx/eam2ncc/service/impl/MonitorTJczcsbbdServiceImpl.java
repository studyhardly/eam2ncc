package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.dao.MonitorTJczcsbbdDao;
import com.ssx.eam2ncc.entity.MonitorTJczcsbbd;
import com.ssx.eam2ncc.entity.Xtywbill;
import com.ssx.eam2ncc.service.MonitorTJczcsbbdService;
import com.ssx.eam2ncc.service.XtywbillService;
import com.ssx.eam2ncc.utils.GetCreateUserCode;
import com.ssx.eam2ncc.utils.GetXtywUser;
import com.ssx.eam2ncc.utils.SendDingDingMesUtil;
import com.ssx.eam2ncc.utils.SendDingDingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MonitorTJczcsbbd)表服务实现类
 *
 * @author youth
 * @since 2022-02-15 16:43:36
 */
@Service("monitorTJczcsbbdService")
@Slf4j
public class MonitorTJczcsbbdServiceImpl implements MonitorTJczcsbbdService {
    @Resource
    private MonitorTJczcsbbdDao monitorTJczcsbbdDao;
    @Resource
    private XtywbillService xtywbillService;
    @Resource
    GetCreateUserCode getUserCode;
    @Resource
    GetXtywUser ywUser;


    /**
     * 查询资产设备变动单据
     *
     * @param flag
     * @return
     */
    @Override
    public String sendMessage(Integer flag) throws Exception {
        List<MonitorTJczcsbbd> list = monitorTJczcsbbdDao.queryByFlag(flag);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                //按单据发送钉钉通知
                String ywid = list.get(i).getTid();
                // 获取制单人
                String userCode = getUserCode.getUserCode(ywid,"zdr");
                //获取运维人员
                String ywUserCode = ywUser.xtywUserList();
                StringBuffer userList = new StringBuffer();
                StringBuffer message = new StringBuffer();
                if (userCode!=null){
                    userList.append(userCode).append(",");
                }
                if (ywUserCode.length()>0){
                    userList.append(ywUserCode);
                }
                log.info("推送人员工号：{}",userList);
                Integer billid = xtywbillService.getBillInfoByGid(Integer.parseInt(ywid)).getBillid();
               if(list.get(i).getSysncstatus()==0){
                   message.append("EAM系统资产信息变动单据 ").append(billid).append(" 推送NCC系统成功");
                   log.info("推送成功消息内容:{}",message);
                   SendDingDingMessage.sendToDingDingMessage(userList.toString(),message.toString());
               }else{
                   message.append("EAM系统资产信息变动单据 ")
                           .append(billid).append(" 推送NCC系统失败\n")
                           .append("失败原因：\n")
                           .append(list.get(i).getSysncmessage())
                           .append("\n请联系EAM系统运维人员处理！");
                   log.info("推送失败消息内容:{}",message);
                   //SendDingDingMessage.sendToDingDingMessage(userList.toString(),message.toString());
                   SendDingDingMesUtil.SendDingTalkMsgByUserId(userList.toString(),message.toString());
               }
               //回写状态
                this.updateFlagByTid(ywid,0);
            }
            return "资产信息变动推送钉钉完成";
        }
        return "当前无资产信息变动集成记录，无需推送钉钉消息！";
    }

    /**
     * 根据tid 修改最新标识
     *
     * @param tid
     * @param flag
     * @return
     */
    @Override
    public Integer updateFlagByTid(String tid, Integer flag) {
        return monitorTJczcsbbdDao.updateByYwid(tid, flag);
    }
}
