package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.entity.MonitorTZccz;
import com.ssx.eam2ncc.dao.MonitorTZcczDao;

import com.ssx.eam2ncc.service.MonitorTZcczService;
import com.ssx.eam2ncc.service.XtywbillService;
import com.ssx.eam2ncc.utils.GetXtywUser;
import com.ssx.eam2ncc.utils.SendDingDingMesUtil;
import com.ssx.eam2ncc.utils.SendDingDingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * (MonitorTZccz)表服务实现类
 *
 * @author youth
 * @since 2022-02-16 12:00:58
 */
@Service("monitorTZcczService")
@Slf4j
public class MonitorTZcczServiceImpl implements MonitorTZcczService {
    @Resource
    private MonitorTZcczDao monitorTZcczDao;
    @Resource
    private XtywbillService xtywbillService;
    @Resource
    private GetXtywUser xtywUser;


    @Override
    public String sendDingDingMessages(Integer isNew) throws Exception {
        List<MonitorTZccz> list = this.monitorTZcczDao.queryAllByFlag(1);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                MonitorTZccz zccz = list.get(i);
                String tid = zccz.getTid();
                Integer billid = this.xtywbillService.getBillInfoByGid(Integer.parseInt(tid)).getBillid();
                StringBuffer message = new StringBuffer();
                StringBuffer userlist = new StringBuffer();
                message.append("资产处置业务单据：")
                        .append(billid).append("\n摘要：")
                        .append(zccz.getPosummary())
                        .append("\n推送NCC系统失败\n失败原因:")
                        .append(zccz.getSysncmessage())
                        .append("\n请联系系统运维人员处理！");
                String tbr = zccz.getTbr();
                if (tbr.length() == 6) {
                    userlist.append(tbr).append(",");
                }
                String ywuser = xtywUser.xtywUserList();
                if (ywuser.length() > 0) {
                    userlist.append(ywuser);
                }
                log.info("资产处置发送消息用户：{}", userlist);
                log.info("资产处置发送消息内容：{}", message);
                //发送钉钉消息
                // SendDingDingMessage.sendToDingDingMessage(userlist.toString(),message.toString());
                SendDingDingMesUtil.SendDingTalkMsgByUserId(userlist.toString(),message.toString());
                //修改状态
                this.update(tid,0);
            }
            return "资产处置发送用户消息成功！";
        }
        return "暂无资产处置集成记录,无需发送钉钉消息！";
    }

    @Override
    public Integer update(String tid, Integer isNew) {
        return this.monitorTZcczDao.update(tid,isNew);
    }
}
