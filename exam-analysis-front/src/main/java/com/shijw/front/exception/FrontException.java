package com.shijw.front.exception;

import com.shijw.front.enums.FrontExceptionEnum;
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
public class FrontException extends RuntimeException {

    private Integer code;

    private String message;

    public FrontException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public FrontException(FrontExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
    }
}
