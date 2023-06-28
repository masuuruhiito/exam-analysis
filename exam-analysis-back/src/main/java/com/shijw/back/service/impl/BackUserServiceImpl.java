package com.shijw.back.service.impl;

import com.shijw.back.config.CommonConfig;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.enums.BackExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.exception.BackException;
import com.shijw.back.mapper.BackUserMapper;
import com.shijw.back.model.BackUser;
import com.shijw.back.model.BackUserExample;
import com.shijw.back.service.IBackUserService;
import com.shijw.back.service.ITokenService;
import com.shijw.back.web.params.BackUserLoginParams;
import com.shijw.back.web.params.BackUserRegisterParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/6 23:40
 */
@Service
public class BackUserServiceImpl implements IBackUserService {

    @Autowired
    private BackUserMapper backUserMapper;
    @Autowired
    private ITokenService tokenService;
    @Autowired
    private CommonConfig commonConfig;

    @Override
    public void register(BackUserRegisterParams params) {
        // 检查是否有相同用户名
        BackUserExample backUserExample = new BackUserExample();
        backUserExample.createCriteria().andUsernameEqualTo(params.getUsername());
        List<BackUser> sameUsernameList = backUserMapper.selectByExample(backUserExample);
        // 用户名重复则抛出异常
        if (!CollectionUtils.isEmpty(sameUsernameList)) {
            throw new BackBusinessException(BackBusinessExceptionEnum.SAME_USERNAME_EXCEPTION);
        }
        // 注册新用户
        BackUser backUser = new BackUser();
        BeanUtils.copyProperties(params, backUser);
        int res = backUserMapper.insertSelective(backUser);
        if (res != 1) {
            throw new BackException(BackExceptionEnum.DATA_INSERT_ERROR);
        }
    }

    @Override
    public String login(BackUserLoginParams params) {
        // 查找是否存在当前用户
        BackUserExample backUserExample = new BackUserExample();
        backUserExample.createCriteria()
                .andUsernameEqualTo(params.getUsername())
                .andPasswordEqualTo(params.getPassword());

        List<BackUser> resList = backUserMapper.selectByExample(backUserExample);
        // 如果数据库中不存在当前用户
        if (resList.size() < 1) {
            throw new BackBusinessException(BackBusinessExceptionEnum.USERNAME_OR_PASSWORD_ERROR_EXCEPTION);
        }
        BackUser curUser = resList.get(0);
        // 获取当前用户 token 并返回
        return commonConfig.getJwtTokenHead() + tokenService.getToken(curUser.getUsername(), curUser.getPassword());
    }

    @Override
    public BackUser queryUserByToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        String username = tokenService.getUserName(token);
        // 根据 username 进行查询
        BackUserExample userExample = new BackUserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        // 最多 size == 1
        List<BackUser> user = backUserMapper.selectByExample(userExample);
        return user.get(0);
    }
}
