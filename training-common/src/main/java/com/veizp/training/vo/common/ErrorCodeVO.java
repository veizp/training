package com.veizp.training.vo.common;

public enum ErrorCodeVO {

    OK(200, "请求成功"), FAILED(400, "请求失败"), SERVER_ERROR(500, "服务器异常"), AUTH_FAILED(999, "未登录");

    private int code;

    private String msg;

    ErrorCodeVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
