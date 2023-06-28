package com.shijw.back.enums;

import com.shijw.back.constant.WebConstant;

import java.util.Objects;

/**
 * @author zgy
 * @version 1.0
 * @date 2021/3/2
 */
public enum BackExceptionEnum {

    /**
     * 数据库操作异常
     */
    DATA_INSERT_ERROR(10001, "数据插入失败"),
    CUR_FUNC_HAVE_NO_UNIVERSITY_ID_EXCEPTION(10002, "当前操作需传 university id 字段，请校验代码逻辑"),


    SIGN_ILLEGAL(WebConstant.RESULT_FORBIDDEN_CODE, "签名错误"),

    QPS_LIMIT(WebConstant.RESULT_FORBIDDEN_CODE, "每秒请求频率超限"),

    SERVER_ERROR(WebConstant.RESULT_SERVER_ERROR_CODE, "服务器内部异常"),

    NOT_RES_FROM_USER(WebConstant.RESULT_SERVER_ERROR_CODE, "用户中心查取失败"),

    ;

    public static BackExceptionEnum getByCode(Integer code) {
        for (BackExceptionEnum exceptionEnum : BackExceptionEnum.values()) {
            if (Objects.equals(code, exceptionEnum.getCode())) {
                return exceptionEnum;
            }
        }
        return null;
    }

    private Integer code;
    private String msg;

    BackExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
