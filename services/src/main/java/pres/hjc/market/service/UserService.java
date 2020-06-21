package pres.hjc.market.service;

import pres.hjc.market.po.UsersModel;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  16:54
 * @description :
 */
public interface UserService {

    void deleteUser(Long id);

    UsersModel queryByUserName(String userName);
}
