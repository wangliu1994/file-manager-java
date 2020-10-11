/*
 * www.unisinsight.com Inc.
 * Copyright (c) 2018 All Rights Reserved
 */
package com.winnie.filemanagerjava.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * description
 *
 * @author t17153 [tan.gang@h3c.com]
 * @date 2018/12/04 15:03
 * @since 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 全局异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalHandle(Exception e) {
        ErrorResult result = new ErrorResult();
        result.setErrorCode("10000");
        result.setMessage(e.getMessage());
        log.error("unknown exception={}", e.getMessage(), e);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 异常返回体
     */
    class ErrorResult {
        /**
         * 异常code
         */
        private String errorCode;
        /**
         * 异常信息
         */
        private String message;

        public String getErrorCode() {
            return errorCode;
        }

        /**
         * 设置异常code
         *
         * @param errorCode 异常code
         */
        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
