package com.ssx.eam2ncc.service.impl;

import com.ssx.eam2ncc.entity.VZczjKpmx;
import com.ssx.eam2ncc.dao.VZczjKpmxDao;
import com.ssx.eam2ncc.service.VZczjKpmxService;
import com.ssx.eam2ncc.utils.JsonFormat;
import com.ssx.eam2ncc.utils.XMLFormat;
import com.ssx.eam2ncc.utils.XmlFormateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (VZczjKpmx)表服务实现类
 *
 * @author makejava
 * @since 2021-12-27 08:30:50
 */
@Service("vZczjKpmxService")
@Slf4j
public class VZczjKpmxServiceImpl implements VZczjKpmxService {
    @Resource
    private VZczjKpmxDao vZczjKpmxDao;

    @Override
    public String queryKpmxByZcbm(String[] zcbmlist) throws Exception {
        List<VZczjKpmx> list = this.vZczjKpmxDao.queryKpmxByZcbm(zcbmlist);
        if (list.size() > 0) {
            String res = JsonFormat.kpmxForamt(list);
            StringBuffer sb = new StringBuffer();
            sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soaw=\"http://soaware.ygsoft.com\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <soaw:receiveInfo>\n" +
                    "         <soaw:args0>?</soaw:args0>\n" +
                    "         <soaw:args1> \n");
            sb.append(res);
            sb.append("    \n</soaw:args1>\n" +
                    "      </soaw:receiveInfo>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>");
            res = sb.toString();
            res = XmlFormateUtil.format(res);
//            res = XMLFormat.formatXML_str(res);
            log.info("格式化后的资产增加报文：\n {}",res);
            return res;
        } else {
            return "未查询到资产编码相关的信息 ,请核对资产编码或接口类型 !!";
        }

    }

}
