package com.ssx.eam2ncc.daoTest;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ssx.eam2ncc.api.HutoolUtils;
import com.ssx.eam2ncc.dao.MonitorTJczczjDao;
import com.ssx.eam2ncc.entity.MonitorTJczczj;
import com.ssx.eam2ncc.service.impl.XtywbillServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ZczjMointorTest {

    @Resource
    MonitorTJczczjDao monitorTJczczjDao;
    @Resource
    XtywbillServiceImpl xtywbillService;

    @Test
    public void getInfo() {
        List<MonitorTJczczj> list = monitorTJczczjDao.queryByFlag(1);
        Map<String, List<MonitorTJczczj>> map = list.stream().collect(
                Collectors.groupingBy(
                        res -> res.getPosummary()
                ));
        System.out.println(JSONUtil.toJsonPrettyStr(map));
        System.out.println(map.get("123"));
    }

    @Test
    public void updateFlag() {
        Integer res = monitorTJczczjDao.updateFlagByTid("ssx-cs", 1);
        System.out.println(res);
    }


    @Test
    public void getInfo2() {
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
        System.out.println(ywids.toString());
        for (int i = 0; i < ywids.size(); i++) {
            StringBuffer successMsg = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            //查成功的
            successList = monitorTJczczjDao.queryByYwidAndStatus(ywids.get(i), 0);
            //成功的
            if (successList.size() > 0) {
                //发成功消息
                //String gid = xtywbillService.getBillInfoByGid(Integer.parseInt(successList.get(0).getPosummary())).getGid().toString();
                String gid = successList.get(0).getPosummary();
                successMsg.append("资产转固单据:").append(gid).append("\n");
                for (int j = 0; j < successList.size(); j++) {
                    successMsg.append("资产编码：").append(successList.get(j).getTid()).append("\n");
                }
                successMsg.append("同步NCC系统成功\n");
                //发送成功消息
                sendToDingDingMessage("851143,855030", successMsg.toString());

            }


            //查失败的
            failedList = monitorTJczczjDao.queryByYwidAndStatus(ywids.get(i), 1);
            if (failedList.size() > 0) {
                //发成功消息
                //String gid  = xtywbillService.getBillInfoByGid(Integer.parseInt(failedList.get(0).getPosummary())).getGid().toString();
                String gid =  failedList.get(0).getPosummary();
                sb.append("资产转固单据编码:").append(gid).append("\n");
                for (int k = 0; k < failedList.size(); k++) {
                    sb.append("资产编码：").append(failedList.get(k).getTid()).append("\n同步NCC系统失败\n失败原因: \n").append(failedList.get(k).getSysncmessage()).append(" ;\n");
                }
                sb.append("请联系运维人员处理！");
               log.info("同步失败消息：",sb);
                //发送钉钉通知
                sendToDingDingMessage("851143,855030", sb.toString());
                //sendMdMes("851143",sb.toString(),"EAM资产转固推送NCC结果");
            }

        }

    }

    public static void sendToDingDingMessage(String userCode, String content) {
        System.out.println("调用接口发送钉钉消息");
        String url = "http://gxcx.jnmc.com:8888/sendTextMsg";
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("userList", userCode);
        jsonObject.putOpt("content", content);
        jsonObject.putOpt("title", "同步NCC成功");
        HutoolUtils.doPost(url, jsonObject);
    }

    public static void sendMdMes(String userCode, String content ,String title ) {
        String url = "http://gxcx.jnmc.com:8888/sendMarkDownMsg";
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("userList", userCode);
        jsonObject.putOpt("title", title);
        jsonObject.putOpt("text", content);
        HutoolUtils.doPost(url, jsonObject);

    }

    public static void main(String[] args) {
        sendMdMes("851143","#### 财务管控至1第三方系统-映射[管控类型:使用管理单位(SYGLDW),第三方类型:使用管理单位(ZZCZ),映射值:1665305,映射值名称:,映射字段:data/sydw]未找到#newLine#财务管控至第三方系统-映射[管控类型:单位(DWDH),第三方类型:单位(DWDH),映射值:012B,映射值名称:,映射字段:data/compid]未找到#newLine# ;","EAM资产转固同步NCC结果");
    }
}
