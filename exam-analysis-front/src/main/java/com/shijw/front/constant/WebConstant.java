package com.shijw.front.constant;

/**
 * 返回给web页面的状态码
 *
 * @author zgy
 * @version 1.0
 * @date 2021/1/28
 */
public class WebConstant {
    public static final String TEST_USER_ID_ATTR = "__TEST__USER_ID__";//请求参数中带这个的直接使用这个参数获取用户id
    public static final String TEST_YDUSER_ID_ATTR = "__TEST__YDUSER_ID__";//请求参数中带这个的直接使用这个参数获取用户id
    public static final String VIRTUAL_YDUSER_ID_ATTR = "virtualUserId";//请求参数中带这个的直接使用这个参数获取用户id

    //返回状态码
    public static final String RESULT_CODE = "code";
    public static final String RESULT_MSG = "msg";
    public static final String RESULT_OK = "OK";
    public static final String RESULT_REASON = "reason";
    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FAILED = "failed";
    public static final int RESULT_OK_CODE = 0;//OK code
    public static final int RESULT_FAILED_CODE = -1;//failed code
    public static final int RESULT_BAD_REQUEST_CODE = 400;//Bad Request //参数错误
    public static final int RESULT_FORBIDDEN_CODE = 403; //Forbidden    //未登陆错误
    public static final int RESULT_NOFOUND_ERROR_CODE = 404;//not found error    //未找到错误
    public static final int RESULT_SERVER_ERROR_CODE = 500;//Internal Server Error //服务器内部错误
    public static final int RESULT_NOTKNOW_ERROR_CODE = 503;//not know error    //未知错误
    public static final int RESULT_USER_DEFINE_REASON_CODE = 101;//用户自定义信息code

    /**
     * 用户登录注册错误码
     */
    public static final int REGISTER_SAME_USERNAME_EXCEPTION = 1001;


    public static final int RESULT_PARAMETER_OVERSIZE = 1002;//参数过大
    public static final int RESULT_PARAMETER_ILLEGAL = 1003;//参数非法
    public static final int RESULT_LANG_ILLEGAL = 1004;//语种非法
    public static final int RESULT_OCR_EMPTY = 1005;//语种非法
    public static final int RESULT_PARAMETER_MISSING = 1006;//参数缺失
    public static final int RESULT_WRITE_MODEL_ILLEGAL = 1007;//参数错误：写作类型
    public static final int RESULT_STYLE_TYPE_ILLEGAL = 1008;//参数错误：文体类型
    public static final int RESULT_EXAM_TYPE_ILLEGAL = 1009;//参数错误：考试类型


    //photo-reading
    public static final int RESULT_OCR_NO_ENGLISH = 2001;//ocr结果没有英文

    /**
     * 写作报告未生成
     */
    public static final int REPORT_NOT_GENERATE = 3001;

    /**
     * 写作报告不存在
     */
    public static final int REPORT_NOT_FOUND = 3002;

    /**
     * 表中没有uniqueId对应数据
     */
    public static final int COR_DATA_NOT_FOUND = 3003;

    /**
     * 写作报告体验次数超出限制
     */
    public static final int REPORT_EXCEED_LIMIT = 3004;

    /**
     * 写作报告无法生成
     */
    public static final int REPORT_CAN_NOT_GENERATE = 3005;

    /**
     * 不是vip
     */
    public static final int NOT_VIP = 4001;

    /**
     * 个人术语库异常
     */
    public static final int PERSONAL_LIB_WORD_FORMAT_ERROR = 5001;
    public static final int PERSONAL_LIB_WORD_ALREADY_EXIST = 5002;
    public static final int PERSONAL_LIB_WORD_NUM_BEYOND_LIMIT = 5003;
    public static final int PERSONAL_LIB_WORD_BE_DELETED_NOT_EXIST = 5004;

    /**
     * 查询记录最新异常
     */
    public static final int CORRECT_RECORD_NOT_LATEST = 6001;

    public static final String REQUEST_COOKIE_ATTRIBUTES = "Cookie";

    /**
     * 环境信息
     */
    public static final String ENVIRONMENT_TEST = "test";

    public static final String ENVIRONMENT_STAGE = "stage";

    public static final String ENVIRONMENT_PROD = "prod";

    /**
     * true、false字符串
     */
    public static final String STRING_TRUE = "true";

    public static final String STRING_FALSE = "false";
}
