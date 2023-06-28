package com.shijw.front.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shijw.front.model.dto.CourseObjectiveDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @ClassName JSONUtils
 * @Description json验证工具
 * @Author zhangxin
 * @Date 2020-08-19
 **/
public class JSONUtils {

    /**
     * 判断是否为json字符串
     *
     * @param content
     * @return
     */
    public static boolean isJSONString(String content) {
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        if (!content.startsWith("{") || !content.endsWith("}")) {
            return false;
        }
        try {
            JSONObject.parse(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<CourseObjectiveDTO> getCourseObjectiveList(String jsonObjectives) {
        return JSONArray.parseArray(jsonObjectives, CourseObjectiveDTO.class);
    }

    /**
     * 判断你一个类是否存在某个属性（字段）
     *
     * @param field 字段
     * @param obj   类对象
     * @return true:存在，false:不存在, null:参数不合法
     */
    public static Boolean isExistField(String field, Object obj) {
        if (obj == null || StringUtils.isEmpty(field)) {
            return null;
        }
        Object o = JSON.toJSON(obj);
        JSONObject jsonObj = new JSONObject();
        if (o instanceof JSONObject) {
            jsonObj = (JSONObject) o;
        }
        return jsonObj.containsKey(field);
    }
}


