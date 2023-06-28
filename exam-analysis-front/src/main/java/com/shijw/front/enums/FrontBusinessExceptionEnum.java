package com.shijw.front.enums;


import java.util.Objects;

/**
 * @author zgy
 * @version 1.0
 * @date 2021/3/2
 */
public enum FrontBusinessExceptionEnum {

    /**
     * 用户登录注册异常
     */
    SAME_USERNAME_EXCEPTION(1001, "用户名重复，请重新设置！"),
    USERNAME_OR_PASSWORD_ERROR_EXCEPTION(1002, "用户名或密码错误，请重新登录！"),

    /**
     * 登录、身份验证异常
     */
    HAVE_NO_TOKEN_EXCEPTION(2001, "无Token，请重新登录！"),
    TOKEN_ERROR_EXCEPTION(2002, "Token错误，请重新登录！"),
    TOKEN_CHECK_FAIL_EXCEPTION(2003, "Token验证失败，请重新登录！"),
    CUR_USER_PERMISSION_TOO_LOW_EXCEPTION(2004, "当前用户身份权限太低，禁止访问！"),
    USER_UNIVERSITY_DONT_MATCH_OPERATION_UNIVERSITY_EXCEPTION(2005, "用户所属学校与操作学校不匹配，禁止访问！"),
    GENERATE_TOKEN_IS_EMPTY_EXCEPTION(2006, "生成Token为空"),
    GET_USERNAME_BY_TOKEN_FAIL_EXCEPTION(2007, "Token验证失败：解析用户名错误！"),
    CANNOT_OPERATE_A_SCHOOL_THAT_IS_NOT_REGISTERED_EXCEPTION(2008, "无法操作未注册过的学校，请检查操作学校标识码"),

    /**
     * 课程注册查询异常
     */
    COURSE_NAME_EXIST_IN_BACKSTAGE_COURSE_DATABASE_EXCEPTION(3001, "当前课程在后台信息库已存在，请误重复创建！"),
    COURSE_NAME_EXIST_IN_PERSONAL_COURSE_DATABASE_EXCEPTION(3002, "当前课程在个人课程库已存在，请误重复创建！"),

    /**
     * 班级注册查询异常
     */
    CLASS_EXIST_IN_BACKSTAGE_CLASS_DATABASE_EXCEPTION(4001, "当前班级在后台信息库已存在，请误重复创建！"),
    CLASS_EXIST_IN_PERSONAL_CLASS_DATABASE_EXCEPTION(4002, "当前课程在个人课程库已存在，请误重复创建！"),

    /**
     * 学生注册查询异常
     */
    REGISTER_STUDENT_CLASS_IS_NOT_EXIST_EXCEPTION(5001, "注册的班级不存在"),
    ;


    private final Integer code;

    private final String msg;

    FrontBusinessExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static FrontBusinessExceptionEnum getByCode(Integer code) {
        for (FrontBusinessExceptionEnum exceptionEnum : FrontBusinessExceptionEnum.values()) {
            if (Objects.equals(code, exceptionEnum.getCode())) {
                return exceptionEnum;
            }
        }
        return null;
    }
}
