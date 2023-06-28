package com.shijw.front.service;

public interface ITokenService {

    public String getToken(String userId, String password);//生成token
    public String getUserName(String token);//通过token找到userid
    public boolean checkSign(String token, String password);//验证token真伪
    public String getRemoveTokenHeadToken(String token);
    public String getUsernameFromRequestHead();
    public String getTokenFromRequestHead();
}
