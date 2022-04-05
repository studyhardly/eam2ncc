package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.entity.VZcczKpmx;
import com.ssx.eam2ncc.dao.VZcczKpmxDao;
import com.ssx.eam2ncc.service.VZcczKpmxService;
import com.ssx.eam2ncc.utils.JsonFormat;
import com.ssx.eam2ncc.utils.XmlFormateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * (VZcczKpmx)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 08:38:56
 */
@Service("vZcczKpmxService")
@Slf4j
public class VZcczKpmxServiceImpl implements VZcczKpmxService {

    @Resource
    VZcczKpmxDao vZcczKpmxDao;

    @Override
    public String queryZcczKpmx(String ywid) {
        List<VZcczKpmx> list = this.vZcczKpmxDao.queryZcczKpmx(ywid);
        if (list.size() > 0) {
            String res =  JsonFormat.zcczForamt(list);
            //组装报文并格式化输出
            StringBuffer sb = new StringBuffer();
            sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soaw=\"http://soaware.ygsoft.com\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <soaw:receiveInfo>\n" +
                    "         <soaw:args0>?</soaw:args0>\n" +
                    "         <soaw:args1> \n");
            sb.append(res);
            sb.append("     \n</soaw:args1>\n" +
                    "      </soaw:receiveInfo>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>");
            res=sb.toString();
            res = XmlFormateUtil.format(res);
            log.info("格式化报文内容：\n {}",res);
            return res;
        } else {
            return "该业务单据id未查询到相关的资产处置明细，请核ywid或接口类型 !!";
        }

    }


}
