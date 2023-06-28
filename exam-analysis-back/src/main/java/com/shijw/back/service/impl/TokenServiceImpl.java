package com.shijw.back.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.shijw.back.config.CommonConfig;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.service.ITokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author weikun
 * @date 2021/12/23 20:44
 */
@Service
public class TokenServiceImpl implements ITokenService {

    @Autowired
    private CommonConfig commonConfig;

    @Override
    public String getToken(String username, String password) {
        String token = "";
        try {
            Date date = new Date(System.currentTimeMillis() + commonConfig.getExpiration());
            token = JWT.create().withAudience(username).withExpiresAt(date).sign(Algorithm.HMAC256(password));
        } catch (Exception e) {
            throw new BackBusinessException(BackBusinessExceptionEnum.GENERATE_TOKEN_IS_EMPTY_EXCEPTION);
        }
        return token;
    }

    @Override
    public String getUserName(String token) {
        try {
            return JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            throw new BackBusinessException(BackBusinessExceptionEnum.GET_USERNAME_BY_TOKEN_FAIL_EXCEPTION);
        }
    }

    @Override
    public boolean checkSign(String token, String password) {
        if (token == null) {
            throw new BackBusinessException(BackBusinessExceptionEnum.HAVE_NO_TOKEN_EXCEPTION);
        }
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(password)).build();
            jwtVerifier.verify(token);
        } catch (Exception e) {
            throw new BackBusinessException(BackBusinessExceptionEnum.TOKEN_ERROR_EXCEPTION);
        }
        return true;
    }

    @Override
    public String getRemoveTokenHeadToken(String token) {
        if (StringUtils.isBlank(token)) {
            throw new BackBusinessException(BackBusinessExceptionEnum.HAVE_NO_TOKEN_EXCEPTION);
        }
        if (!token.startsWith(commonConfig.getJwtTokenHead())) {
            throw new BackBusinessException(BackBusinessExceptionEnum.TOKEN_ERROR_EXCEPTION);
        }
       return token.substring(commonConfig.getJwtTokenHead().length());
    }
}
