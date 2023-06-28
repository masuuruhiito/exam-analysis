package com.shijw.front.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.shijw.front.config.CommonConfig;
import com.shijw.front.enums.FrontBusinessExceptionEnum;
import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.mapper.FrontUserMapper;
import com.shijw.front.service.ITokenService;
import com.shijw.front.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author weikun
 * @date 2021/12/23 20:44
 */
@Service
public class TokenServiceImpl implements ITokenService {

    @Autowired
    private CommonConfig commonConfig;
    @Autowired
    private FrontUserMapper frontUserMapper;

    @Override
    public String getToken(String username, String password) {
        String token = "";
        try {
            Date date = new Date(System.currentTimeMillis() + commonConfig.getExpiration());
            token = JWT.create().withAudience(username).withExpiresAt(date).sign(Algorithm.HMAC256(password));
        } catch (Exception e) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.GENERATE_TOKEN_IS_EMPTY_EXCEPTION);
        }
        return token;
    }

    @Override
    public String getUserName(String token) {
        try {
            return JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.GET_USERNAME_BY_TOKEN_FAIL_EXCEPTION);
        }
    }

    @Override
    public boolean checkSign(String token, String password) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(password)).build();
            jwtVerifier.verify(token);
        } catch (Exception e) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.TOKEN_ERROR_EXCEPTION);
        }
        return true;
    }

    @Override
    public String getRemoveTokenHeadToken(String token) {
        if (StringUtils.isBlank(token)) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.HAVE_NO_TOKEN_EXCEPTION);
        }
        if (!token.startsWith(commonConfig.getJwtTokenHead())) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.TOKEN_ERROR_EXCEPTION);
        }
        return token.substring(commonConfig.getJwtTokenHead().length());
    }

    @Override
    public String getTokenFromRequestHead() {
        HttpServletRequest request = CommonUtil.getRequest();
        String tokenWithHead = request.getHeader(commonConfig.getJwtTokenHeader());
        return getRemoveTokenHeadToken(tokenWithHead);
    }

    @Override
    public String getUsernameFromRequestHead() {
        return getUserName(getTokenFromRequestHead());
    }
}
