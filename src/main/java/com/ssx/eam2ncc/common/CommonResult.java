package com.ssx.eam2ncc.common;

public class CommonResult {
    public int statusCode;
    public String statusMsg;
    public Object data;

    public CommonResult(int statusCode,String statusMsg,Object data){
        super();
        this.statusCode=statusCode;
        this.statusMsg=statusMsg;
        this.data=data;
    }

    public static CommonResult success(Object data){
        return new CommonResult(200,"处理成功",data);
    }

    public static CommonResult fail(Object data){
        return new CommonResult(500,"处理失败",data);
    }
}
