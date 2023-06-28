package com.shijw.front.service.impl;

import com.shijw.front.config.CommonConfig;
import com.shijw.front.enums.FrontBusinessExceptionEnum;
import com.shijw.front.enums.FrontExceptionEnum;
import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.exception.FrontException;
import com.shijw.front.mapper.FrontUserMapper;
import com.shijw.front.model.FrontUser;
import com.shijw.front.model.example.FrontUserExample;
import com.shijw.front.model.vo.UserInfoVO;
import com.shijw.front.service.IFrontUserService;
import com.shijw.front.service.ITokenService;
import com.shijw.front.web.params.FrontUpdateUserInfoParams;
import com.shijw.front.web.params.FrontUserLoginParams;
import com.shijw.front.web.params.FrontUserRegisterParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/12 18:58
 */
@Service
public class FrontUserServiceImpl implements IFrontUserService {

    @Autowired
    private FrontUserMapper frontUserMapper;
    @Autowired
    private CommonConfig commonConfig;
    @Autowired
    private ITokenService tokenService;


    @Override
    public void register(FrontUserRegisterParams params) {
        // 检查是否有相同用户名
        FrontUserExample frontUserExample = new FrontUserExample();
        frontUserExample.createCriteria().andUsernameEqualTo(params.getUsername());
        List<FrontUser> sameUsernameList = frontUserMapper.selectByExample(frontUserExample);
        // 用户名重复则抛出异常
        if (!CollectionUtils.isEmpty(sameUsernameList)) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.SAME_USERNAME_EXCEPTION);
        }
        // 注册新用户
        FrontUser frontUser = new FrontUser();
        BeanUtils.copyProperties(params, frontUser);

        int res = frontUserMapper.insertSelective(frontUser);
        if (res != 1) {
            throw new FrontException(FrontExceptionEnum.DATA_INSERT_ERROR);
        }
    }

    @Override
    public String login(FrontUserLoginParams params) {
        // 查找是否存在当前用户
        FrontUserExample frontUserExample = new FrontUserExample();
        frontUserExample.createCriteria()
                .andUsernameEqualTo(params.getUsername());

        List<FrontUser> resList = frontUserMapper.selectByExample(frontUserExample);
        // 如果数据库中不存在当前用户
        if (resList.size() < 1) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.USERNAME_OR_PASSWORD_ERROR_EXCEPTION);
        }
        FrontUser curUser = resList.get(0);
        // 获取当前用户 token 并返回
        return commonConfig.getJwtTokenHead() + tokenService.getToken(curUser.getUsername(), curUser.getPassword());
    }

    @Override
    public UserInfoVO info() {
        String username = tokenService.getUsernameFromRequestHead();
        FrontUser frontUser = getUserByUsername(username);
        UserInfoVO res = new UserInfoVO();
        BeanUtils.copyProperties(frontUser, res);
        return res;
    }

    @Override
    public FrontUser getUserByUsername(String username) {
        return frontUserMapper.selectByUsername(username);
    }

    @Override
    public void updateInfo(FrontUpdateUserInfoParams params) {
        String username = tokenService.getUsernameFromRequestHead();
        FrontUser frontUser = getUserByUsername(username);
        BeanUtils.copyProperties(params, frontUser);
        frontUserMapper.updateByPrimaryKeySelective(frontUser);
    }
}
