package com.shijw.front.service;

import com.shijw.front.model.FrontUser;
import com.shijw.front.model.vo.UserInfoVO;
import com.shijw.front.web.params.FrontUpdateUserInfoParams;
import com.shijw.front.web.params.FrontUserLoginParams;
import com.shijw.front.web.params.FrontUserRegisterParams;

/**
 * @author SHI
 * @date 2023/4/12 18:57
 */
public interface IFrontUserService {

    void register(FrontUserRegisterParams params);

    String login(FrontUserLoginParams params);

    UserInfoVO info();

    FrontUser getUserByUsername(String username);

    void updateInfo(FrontUpdateUserInfoParams params);
}
