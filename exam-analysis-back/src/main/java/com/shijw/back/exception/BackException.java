package com.shijw.back.exception;

import com.shijw.back.enums.BackExceptionEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常，返回httpcode500，让客户端算作失败的请求
 *
 * @author zgy
 * @version 1.0
 * @date 2021/1/28
 */
@Getter
@Setter
public class BackException extends RuntimeException {

    private Integer code;

    private String message;

    public BackException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BackException(BackExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
    }
}
