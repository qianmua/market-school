package pres.hjc.market.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pres.hjc.market.global.status.UserStatusEnum;
import pres.hjc.market.impl.UserDetail;
import pres.hjc.market.po.UsersModel;
import pres.hjc.market.service.UserService;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  18:32
 * @description :
 */
public class UserDetailsHandler implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * user token
     * @param username username
     * @return 封装 info
     * @throws UsernameNotFoundException not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询用户
        UsersModel usersModel = userService.queryByUserName(username);

        // 登录 失败
        if (usersModel == null){
            throw new AuthenticationCredentialsNotFoundException("user not found");
        }else if (usersModel.getStatus().equals(UserStatusEnum.LOCKDE.getStatus())){
            throw new LockedException("账户 被锁定");
        }else if (usersModel.getStatus().equals(UserStatusEnum.DISABLE.getStatus())){
            throw new DisabledException("账户 被 注销");
        }

        UserDetail detail = new UserDetail();

        // 查询 权限

        // set
        detail.setMenuModels(null);


        return detail;
    }
}
