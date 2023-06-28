package com.shijw.front.utils;

import com.alibaba.fastjson.JSONObject;
import com.shijw.front.constant.WebConstant;

/**
 * Web相关的工具方法集合
 *
 * @author zgy
 * @version 1.0
 * @date 2021/1/28
 */
public final class WebUtil {

    /**
     * 函数功能：返回只有code 和 msg 的数据
     *
     * @param code:返回code
     * @param msg:code信息
     * @return Object：返回的json字符串
     */
    public static Object result(int code, String msg) {
        JSONObject obj = new JSONObject();
        obj.put(WebConstant.RESULT_CODE, code);
        obj.put(WebConstant.RESULT_MSG, msg);
        return obj;
    }

    /**
     * 函数功能：返回获取数据成功时的数据
     *
     * @param key：需要返回Object的显示key
     * @param value:Object的value值
     * @return Object：返回的json字符串
     */
    public static Object succResult(String key, Object value) {
        JSONObject obj = new JSONObject();
        obj.put(WebConstant.RESULT_CODE, WebConstant.RESULT_OK_CODE);
        obj.put(WebConstant.RESULT_MSG, WebConstant.RESULT_OK);
        JSONObject dataObj = new JSONObject();
        dataObj.put(key, value);
        obj.put("data", dataObj);
        return obj;
    }

    /**
     * 函数功能：返回获取数据成功时的数据
     *
     * @param data：需要返回的Object
     * @return Object：返回的json字符串
     */
    public static Object succResult(Object data) {
        JSONObject obj = new JSONObject();
        obj.put(WebConstant.RESULT_CODE, WebConstant.RESULT_OK_CODE);
        obj.put(WebConstant.RESULT_MSG, WebConstant.RESULT_OK);
        obj.put("data", data);
        return obj;
    }

    /**
     * 函数功能：返回无数据的成功结果
     *
     * @return Object：返回的json字符串
     */
    public static Object succResult() {
        JSONObject obj = new JSONObject();
        obj.put(WebConstant.RESULT_CODE, WebConstant.RESULT_OK_CODE);
        obj.put(WebConstant.RESULT_MSG, WebConstant.RESULT_OK);
        return obj;
    }

    /**
     * 函数功能：返回获取数据成功时的数据
     *
     * @param key1   需要返回Object的显示key
     * @param value1 Object的value值
     * @param key2   需要返回Object的显示key
     * @param value2 Object的value值
     * @return 返回的json字符串
     */
    public static Object succResult(String key1, Object value1, String key2, Object value2) {
        JSONObject obj = new JSONObject();
        obj.put(WebConstant.RESULT_CODE, WebConstant.RESULT_OK_CODE);
        obj.put(WebConstant.RESULT_MSG, WebConstant.RESULT_OK);
        JSONObject dataObj = new JSONObject();
        dataObj.put(key1, value1);
        dataObj.put(key2, value2);
        obj.put("data", dataObj);
        return obj;
    }

    /**
     * 函数功能：返回jsonp的数据，可以支持跨域访问
     *
     * @param callback：参数
     * @param result:需返回的数据
     * @return String：支持跨域访问的数据
     */
    public static String jsonp(String callback, String result) {
        if (callback == null || callback.isEmpty()) {
            return result;
        }
        return callback + "(" + result + ")";
    }

    /**
     * 函数功能：获取数据失败时的提示返回信息
     *
     * @param code      错误代码
     * @param msg       发生错误的原因
     * @return Object   返回的json字符串
     */
    public static Object errResult(int code, String msg) {
        JSONObject obj = new JSONObject();
        obj.put(WebConstant.RESULT_CODE, code);
        obj.put(WebConstant.RESULT_MSG, msg);
        return obj.toString();
    }

}
