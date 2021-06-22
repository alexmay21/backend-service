package com.todos.backendservice.constant;

/**
 * Common used status code
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
public enum StatusCodeEnum {
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private long code;
    private String message;

    StatusCodeEnum(long code, String message) {
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
