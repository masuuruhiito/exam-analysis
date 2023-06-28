package com.shijw.back.exception;

import com.shijw.back.enums.BackBusinessExceptionEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常，返回httpcode为200，不让客户端算作失败的返回
 * epic
 * @author zgy
 * @version 1.0
 * @date 2021/1/28
 */
@Setter
@Getter
public class BackBusinessException extends RuntimeException {

    private Integer code;

    private String message;

    public BackBusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BackBusinessException(BackBusinessExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
    }

}
