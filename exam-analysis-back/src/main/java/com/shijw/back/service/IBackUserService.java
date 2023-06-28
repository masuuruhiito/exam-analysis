package com.shijw.back.service;

import com.shijw.back.model.BackUser;
import com.shijw.back.web.params.BackUserLoginParams;
import com.shijw.back.web.params.BackUserRegisterParams;

/**
 * @author SHI
 * @date 2023/4/6 23:39
 */
public interface IBackUserService {
    /**
     * 后台系统登录功能
     *
     * @param params 登录所需参数
     * @return 成功登录返回的Token
     */
    String login(BackUserLoginParams params);

    /**
     * 后台系统用户注册接口
     *
     * @param params 登录所需参数
     */
    void register(BackUserRegisterParams params);

    /**
     * 查询用户通过登录token
     *
     * @param token 查询的Token
     * @return 查询返回结果（可为 null）
     */
    BackUser queryUserByToken(String token);
}
