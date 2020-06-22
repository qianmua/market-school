package pres.hjc.market.service;

import pres.hjc.market.dto.Token;
import pres.hjc.market.impl.UserDetail;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/22  16:46
 * @description :
 */
public interface TokenService {

    /**
     * 存储token
     * @param userDetail
     * @return
     */
    Token saveToken(UserDetail userDetail);

    /**
     * 刷新token
     * @param userDetail
     */
    void refresh(UserDetail userDetail);

    /**
     * 得到登录用户
     * @param token
     * @return
     */
    UserDetail getLoginUser(String token);

    /**
     * 移除token
     * @param token
     * @return
     */
    boolean removeToken(String token);
}
