package com.todos.backendservice.model.dto;

import com.todos.backendservice.constant.StatusCodeEnum;
import lombok.Data;

/**
 * Common returned result
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
@Data
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(StatusCodeEnum.OK.getCode(), StatusCodeEnum.OK.getMessage(), data);
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(StatusCodeEnum.BAD_REQUEST.getCode(), message, null);
    }

    public static <T> CommonResult<T> failed(StatusCodeEnum errorCode,String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }

    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(StatusCodeEnum.BAD_REQUEST.getCode(), message, null);
    }
}
