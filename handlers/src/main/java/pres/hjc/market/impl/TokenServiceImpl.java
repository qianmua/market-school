package pres.hjc.market.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pres.hjc.market.dto.Token;
import pres.hjc.market.dto.UserDetail;
import pres.hjc.market.service.TokenService;

import java.util.UUID;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/22  16:53
 * @description : token save to redis
 */
@Slf4j
@Service
@Primary
public class TokenServiceImpl implements TokenService {

    /**
     * token 过期 (秒)
     */
    @Value("${token.expire.seconds}")
    private Integer expireSeconds;

    @Override
    public Token saveToken(UserDetail userDetail) {
        // create token
        String token = UUID.randomUUID().toString();

        userDetail.setToken(token);

        cacheUserSetting(userDetail);

        // 缓存token 到 redis 1

        log.info("login -> to save token");


        return new Token(token,userDetail.getLoginLong());
    }

    @Override
    public void refresh(UserDetail userDetail) {
        cacheUserSetting(userDetail);
    }

    @Override
    public UserDetail getLoginUser(String token) {
        // 用 token 从 redis 取出用户

        return null;
    }

    @Override
    public boolean removeToken(String token) {
        // 清理掉 缓存
        return false;
    }


    /**
     * set base
     * @param userDetail user
     */
    private void cacheUserSetting(UserDetail userDetail){
        userDetail.setLoginLong(System.currentTimeMillis());
        userDetail.setExpireTime(userDetail.getLoginLong() + (expireSeconds * 1000) );
        // 缓存 到 redis

    }


    /**
     * set token redis
     * @param token s
     * @return s
     */
    private String getToken(String token){
        return "token:" + token;
    }
}
