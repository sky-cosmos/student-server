package com.kaiyu.common.api;

/**
 * 封装api的错误码
 */
public interface IErrorCode {
    long getCode();

    String getMessage();

    class CommonResult {
    }
}
