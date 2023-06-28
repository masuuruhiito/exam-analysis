package com.shijw.back.service;

import com.shijw.back.model.BackClass;
import com.shijw.back.model.BackCollege;
import com.shijw.back.model.BackUniversity;
import com.shijw.back.web.params.*;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/6 23:39
 */
public interface IBackCollegeService {

    /**
     * 后台系统登录功能
     *
     * @return 成功登录返回的Token
     * @param params
     */
    BackUniversity query(BackUniversityQueryParams params);

    /**
     * 后台系统登录功能
     *
     * @return 成功登录返回的Token
     * @param universityCode
     */
    List<BackCollege> queryAll(String universityCode);

    /**
     * 后台系统登录功能 注册
     *
     * @param params
     * @return 成功登录返回的Token
     */
    void register(BackCollegeRegisterParams params);
}
