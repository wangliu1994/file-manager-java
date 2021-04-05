package com.winnie.filemanagerjava.common;

import lombok.Data;

/**
 * @Description: TODO
 * @author: winnie
 * @date: 2020年10月11日
 */
@Data
public class Result<T> {
    private static final String SUCCESS_CODE = "0000";

    private T data;

    private String errorCode;

    private String errorMessage;


    private Result(T data) {
        this(data, SUCCESS_CODE, null);
    }

    private Result(T data, String errorCode, String errorMessage) {
        this.data = data;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }
}
