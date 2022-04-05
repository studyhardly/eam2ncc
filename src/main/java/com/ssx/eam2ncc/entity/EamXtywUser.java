package com.ssx.eam2ncc.entity;

import java.io.Serializable;

/**
 * (EamXtywUser)实体类
 *
 * @author youth
 * @since 2022-02-15 10:15:28
 */
public class EamXtywUser implements Serializable {
    private static final long serialVersionUID = -54442651286767529L;



    private String usercode;

    private String username;

    private String status;

    private String remark ;
    public String getIsblock() {
        return status;
    }

    public void setIsblock(String status) {
        this.status = status;
    }



    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public EamXtywUser() {
    }

    public EamXtywUser(String usercode, String username, String status, String remark) {
        this.usercode = usercode;
        this.username = username;
        this.status = status;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "EamXtywUser{" + "usercode='" + usercode + '\'' + ", username='" + username + '\'' +
                ", status='" + status + '\'' + ", remark='" + remark + '\'' + '}';
    }
}

