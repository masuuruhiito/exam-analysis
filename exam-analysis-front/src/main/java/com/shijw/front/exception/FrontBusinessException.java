package com.shijw.front.exception;

import com.shijw.front.enums.FrontBusinessExceptionEnum;
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
public class FrontBusinessException extends RuntimeException {

    private Integer code;

    private String message;

    public FrontBusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public FrontBusinessException(FrontBusinessExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
    }

}
