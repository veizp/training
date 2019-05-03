package com.veizp.training.vo.common;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class IResult<T> {

    private int code;

    private String msg;

    private T data;

    private IResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> IResult<T> create(int code, String msg, T data) {
        return new IResult<T>(code, msg, data);
    }

    public static <T> IResult<T> buildOK() {
        return create(ErrorCodeVO.OK.getCode(), ErrorCodeVO.OK.getMsg(), null);
    }

    public static <T> IResult<T> buildOK(T data) {
        return create(ErrorCodeVO.OK.getCode(), ErrorCodeVO.OK.getMsg(), data);
    }

    public static <T> IResult<T> buildError(String errMsg) {
        return create(ErrorCodeVO.FAILED.getCode(),
                StringUtils.isNotBlank(errMsg) ? errMsg : ErrorCodeVO.FAILED.getMsg(), null);
    }

    public static <T> IResult<T> buildAuthFailed() {
        return AUTH_FAILED;
    }

    private static final IResult AUTH_FAILED = create(ErrorCodeVO.AUTH_FAILED.getCode(),
            ErrorCodeVO.AUTH_FAILED.getMsg(), null);

    public static IResult buildServerError() {
        return SERVER_ERROR;
    }

    private static final IResult SERVER_ERROR = create(ErrorCodeVO.SERVER_ERROR.getCode(),
            ErrorCodeVO.SERVER_ERROR.getMsg(), null);

    public boolean isOK() {
        return ErrorCodeVO.OK.getCode() == code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
