package com.minghai.exception;

/**
 * 自定义异常类
 */
public class SysException  extends  Exception{
    // 存储信息
    private  String message;

    public SysException(String s) {
        this.message=s;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
