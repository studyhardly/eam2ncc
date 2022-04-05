package com.ssx.eam2ncc.utils;

import com.ssx.eam2ncc.entity.EamXtywUser;
import com.ssx.eam2ncc.service.EamXtywUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class GetXtywUser {
    @Resource
    private EamXtywUserService eamXtywUserService;
    public  String xtywUserList() {
        //运维人员
        List<EamXtywUser> ywUser = eamXtywUserService.queryAll();
        StringBuffer sb = new StringBuffer();
        if (ywUser.size() > 0) {
            for (int i = 0; i < ywUser.size(); i++) {
                sb.append(ywUser.get(i).getUsercode()).append(",");
            }
        }
        return sb.toString();
    }
}
