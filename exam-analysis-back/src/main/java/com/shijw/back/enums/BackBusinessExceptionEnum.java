package com.shijw.back.enums;


import java.util.Objects;

/**
 * @author zgy
 * @version 1.0
 * @date 2021/3/2
 */
public enum BackBusinessExceptionEnum {

    /**
     * 用户登录注册异常
     */
    SAME_USERNAME_EXCEPTION(1001, "用户名重复，请重新设置！"),
    USERNAME_OR_PASSWORD_ERROR_EXCEPTION(1002, "用户名或密码错误，请重新登录！"),

    /**
     * 登录、身份验证异常
     */
    HAVE_NO_TOKEN_EXCEPTION(2001, "无token，请重新登录！"),
    TOKEN_ERROR_EXCEPTION(2002, "token错误，请重新登录！"),
    TOKEN_CHECK_FAIL_EXCEPTION(2003, "token验证失败，请重新登录！"),
    CUR_USER_PERMISSION_TOO_LOW_EXCEPTION(2004, "当前用户身份权限太低，禁止访问！"),
    USER_UNIVERSITY_DONT_MATCH_OPERATION_UNIVERSITY_EXCEPTION(2005, "用户所属学校与操作学校不匹配，禁止访问！"),
    GENERATE_TOKEN_IS_EMPTY_EXCEPTION(2006, "生成Token为空"),
    GET_USERNAME_BY_TOKEN_FAIL_EXCEPTION(2007, "通过token获取username失败"),
    CANNOT_OPERATE_A_SCHOOL_THAT_IS_NOT_REGISTERED_EXCEPTION(2008, "无法操作未注册过的学校，请检查操作学校标识码"),

    /**
     * 学校注册查询异常
     */
    CUR_UNIVERSITY_EXISTED_EXCEPTION(3001, "当前系统已注册该学校，请勿重复注册！"),
    REGISTER_UNIVERSITY_CODE_ERROR_EXCEPTION(3002, "注册学校标识码错误，请检查后重试！"),
    REGISTER_UNIVERSITY_NAME_ERROR_EXCEPTION(3003, "注册学校名称错误，请检查后重试！"),
    QUERY_UNIVERSITY_NEED_LEAST_ONE_IS_NOT_EMPTY_PARAMS_EXCEPTION(3004, "查询学校时学校名称或标识码至少有一个不为空"),

    /**
     * 学院注册查询异常
     */
    CUR_COLLEGE_EXISTED_EXCEPTION(4001, "该学校已注册该学院，请勿重复注册！"),

    /**
     * 班级注册查询异常
     */
    CUR_CLASS_EXISTED_EXCEPTION(4001, "该学院已注册该班级，请勿重复注册！"),

    /**
     * 教师注册查询异常
     */
    OPERATE_COLLEGE_ERROR_EXCEPTION(5001, "操作学院错误，请重新检查学院信息！"),
    BINDING_TEACHER_NOT_EXIST_EXCEPTION(5002, "绑定教师信息错误，请检查后重新尝试！"),
    BINDING_CLASS_NOT_EXIST_EXCEPTION(5003, "绑定班级信息错误，请检查后重新尝试！"),

    /**
     * 学生注册查询异常
     */
    OPERATE_CLASS_ERROR_EXCEPTION(6001, "操作班级错误，请重新检查班级信息！"),
    CUR_STUDENT_ID_REGISTERED_EXCEPTION(6002, "当前学号已被注册，请检查输入信息！"),
    ;

    private final Integer code;

    private final String msg;

    BackBusinessExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static BackBusinessExceptionEnum getByCode(Integer code) {
        for (BackBusinessExceptionEnum exceptionEnum : BackBusinessExceptionEnum.values()) {
            if (Objects.equals(code, exceptionEnum.getCode())) {
                return exceptionEnum;
            }
        }
        return null;
    }
}
