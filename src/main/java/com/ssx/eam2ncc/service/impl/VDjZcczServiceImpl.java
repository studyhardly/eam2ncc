package com.ssx.eam2ncc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssx.eam2ncc.entity.VDjZccz;
import com.ssx.eam2ncc.dao.VDjZcczDao;
import com.ssx.eam2ncc.service.VDjZcczService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (VDjZccz)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 11:25:31
 */
@Service("vDjZcczService")
public class VDjZcczServiceImpl implements VDjZcczService {
    @Resource
    private VDjZcczDao vDjZcczDao;


    @Override
    public String qryYwid(String dwdh, String billid) {
        VDjZccz dj = this.vDjZcczDao.qryYwid(dwdh, billid);
        if (dj != null) {
            String jsonString = JSON.toJSONString(dj);
            JSONObject object = JSONObject.parseObject(jsonString);
            String pretty = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteDateUseDateFormat);
            return pretty;
        } else {
            return "未查询到相关单据信息，请检查单位代码或单据编码！";
        }


    }

}
