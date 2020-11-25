package com.kaiyu.common.api;

/**
 * 枚举常用的操作吗
 */
public enum ResultCode implements IErrorCode{
    SUCCESS(200, "successful operation"),
    FAILED(500, "operation failed"),
   VALIDATE_FAILED(405, "parameter verification failed"),
    USERSTATUSERROR(402,"User status is wrong, locked or logged out"),
    UNAUTHORIZED(401, "Not logged in yet or token has expired"),
    FORBIDDEN(403, "No relevant permissions"),
    ROLECANTDELETE(407, "role is being used"),
    USERNOTFOUND(406, "user not found");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
