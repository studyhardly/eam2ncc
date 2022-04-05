package com.ssx.eam2ncc.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssx.eam2ncc.entity.VZcczKpmx;
import com.ssx.eam2ncc.entity.VZczjKpmx;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JsonFormat {
    /**
     * 拼接报文内容并格式化输出
     *资产增加卡片明细
     * @param list
     * @return
     */
    public static String kpmxForamt(List<VZczjKpmx> list) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        // 组装报文
        if (list.size() > 0) {
            String ywid = list.get(0).getYwid().toString();
            sb.append("\"YWID\":" + ywid + ",");
            sb.append("\"datas\":[");

            for (int i = 0; i < list.size(); i++) {
                sb.append("{");
                if (list.get(i).getBillid() != null) {
                    sb.append("\"BILLID\":" + list.get(i).getBillid().toString() + ",");
                }
                if (list.get(i).getCcrq() != null) {
                    sb.append("\"CCRQ\":\"" + list.get(i).getCcrq().toString() + "\",");
                }
                if (list.get(i).getCompid() != null) {
                    sb.append("\"COMPID\":\"" + list.get(i).getCompid().toString() + "\",");
                }
                if (list.get(i).getDxmc() != null) {
                    sb.append("\"DXMC\":\"" + list.get(i).getDxmc().toString() + "\",");
                }
                if (list.get(i).getGgxh() != null) {
                    sb.append("\"GGXH\":\"" + list.get(i).getGgxh().toString() + "\",");
                }
                if (list.get(i).getGlbm() != null) {
                    sb.append("\"GLBM\":\"" + list.get(i).getGlbm().toString() + "\",");
                }
                if (list.get(i).getGys() != null) {
                    sb.append("\"GYS\":\"" + list.get(i).getGys().toString() + "\",");
                }
                if (list.get(i).getJczl() != null) {
                    sb.append("\"JCZL\":" + list.get(i).getJczl().toString() + ",");
                }
                if (list.get(i).getJldw() != null) {
                    sb.append("\"JLDW\":" + list.get(i).getJldw().toString() + ",");
                }

                sb.append("\"JZZB\":" + list.get(i).getJzzb() + ",");

                if (list.get(i).getKssyrq() != null) {
                    sb.append("\"KSSYRQ\":\"" + list.get(i).getKssyrq() + "\",");
                }

                sb.append("\"LJZJ\":" + list.get(i).getLjzj() + ",");

                if (list.get(i).getRzrq() != null) {
                    sb.append("\"RZRQ\":\"" + list.get(i).getRzrq() + "\",");
                }
                if (list.get(i).getSl() != null) {
                    sb.append("\"SL\":" + list.get(i).getSl().toString() + ",");
                }
                if (list.get(i).getSybm() > 0) {
                    sb.append("\"SYBM\":\"" + list.get(i).getSybm() + "\",");
                }
                if (list.get(i).getSydw() != null) {
                    sb.append("\"SYDW\":" + list.get(i).getSydw().toString() + ",");
                }
                if (list.get(i).getSyr() != null) {
                    sb.append("\"SYR\":\"" + list.get(i).getSyr() + "\",");
                }
                if (list.get(i).getSyyx() != null) {
                    sb.append("\"SYYX\":" + list.get(i).getSyyx().toString() + ",");
                }
                if (list.get(i).getSyzt() != null) {
                    sb.append("\"SYZT\":\"" + list.get(i).getSyzt() + "\",");
                }
                if (list.get(i).getSCreateTime() != null) {
                    sb.append("\"S_CREATE_TIME\":\"" + list.get(i).getSCreateTime() + "\",");
                }
                if (list.get(i).getTbr() != null) {
                    sb.append("\"TBR\":\"" + list.get(i).getTbr() + "\",");
                }
                if (list.get(i).getUppertypeid() != null) {
                    sb.append("\"UPPERTYPEID\":\"" + list.get(i).getUppertypeid() + "\",");
                }
                if (list.get(i).getXmmc() != null) {
                    sb.append("\"XMMC\":\"" + list.get(i).getXmmc().toString() + "\",");
                }
                if (list.get(i).getWzxx() != null) {
                    sb.append("\"WZXX\":\"" + list.get(i).getWzxx() + "\",");
                }
                if (list.get(i).getZcbm() != null) {
                    sb.append("\"ZCBM\":\"" + list.get(i).getZcbm() + "\",");
                }
                if (list.get(i).getZcfl() != null) {
                    sb.append("\"ZCFL\":" + list.get(i).getZcfl().toString() + ",");
                }
                sb.append("\"ZCYZ\":" + list.get(i).getZcyz() + ",");
                if (list.get(i).getZczjff() != null) {
                    sb.append("\"ZCZJFF\":\"" + list.get(i).getZczjff() + "\",");
                }
                if (list.get(i).getZczjfs() != null) {
                    sb.append("\"ZCZJFS\":\"" + list.get(i).getZczjfs() + "\",");
                }
                if (list.get(i).getZjjzrq() != null) {

                    sb.append("\"ZJJZRQ\":\"" + list.get(i).getZjjzrq() + "\",");
                }
                if (list.get(i).getZjksrq() != null) {
                    String zjksrq = list.get(i).getZjksrq();
                    sb.append("\"ZJKSRQ\":\"" + zjksrq + "\",");
                }
                if (list.get(i).getZczjfs() != null) {
                    sb.append("\"ZJLX\":\"" + list.get(i).getZczjfs() + "\"");
                }
                sb.append("}");
                if (list.size() > 1 && i < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]}");

        }

        String res = sb.toString();
        //  格式化
        log.info("未格式化报文内容：{}",res);
        JSONObject object = JSONObject.parseObject(res);
        String pretty = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        return pretty;
    }

    /**
     * 资产处置报文
     *
     * @param list
     * @return
     */
    public static String zcczForamt(List<VZcczKpmx> list) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        // 组装报文
        if (list.size() > 0) {
            sb.append("\"dwdh\":\"" + list.get(0).getDwdh() + "\",");
            sb.append("\"summary\":\"" + list.get(0).getSummary() + "\",");
            sb.append("\"tbr\":\"" + list.get(0).getTbr() + "\",");
            sb.append("\"upperTypeId\":\"" + list.get(0).getUppertypeid() + "\",");
            sb.append("\"ywid\":\"" + list.get(0).getYwid() + "\",");
            sb.append("\"zdrq\":\"" + list.get(0).getZdrq() + "\",");
            sb.append("\"datas\":[");
            for (int i = 0; i < list.size(); i++) {
                sb.append("{");
                if (list.get(i).getCzfs() != null) {
                    sb.append("\"czfs\":\"" + list.get(i).getCzfs() + "\",");
                }
                if (list.get(i).getDwdh() != null) {
                    sb.append("\"dwdh\":\"" + list.get(i).getDwdh() + "\",");
                }
                sb.append("\"jcz\":" + list.get(i).getJcz() + ",");
                sb.append("\"jz\":" + list.get(i).getJz() + ",");
                sb.append("\"jzzb\":" + list.get(i).getJzzb() + ",");
                sb.append("\"ljzj\":" + list.get(i).getLjzj() + ",");
                sb.append("\"rzjz\":" + list.get(i).getRzjz() + ",");
                if (list.get(i).getSybm() != null) {
                    sb.append("\"sybm\":\"" + list.get(i).getSybm() + "\",");
                }
                if (list.get(i).getZcbm() != null) {
                    sb.append("\"zcbm\":\"" + list.get(i).getZcbm() + "\",");
                }
                sb.append("\"zcje\":" + list.get(i).getZcje() + ",");
                sb.append("}");
                if (list.size() > 1 && i < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]}");
        }

        String res = sb.toString();
        //  格式化
        JSONObject object = JSONObject.parseObject(res);
        String pretty = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        return pretty;
    }

}
