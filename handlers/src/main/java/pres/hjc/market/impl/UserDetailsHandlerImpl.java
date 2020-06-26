package pres.hjc.market.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pres.hjc.market.global.status.UserStatusEnum;
import pres.hjc.market.dto.UserDetail;
import pres.hjc.market.po.MenuModel;
import pres.hjc.market.po.UsersModel;
import pres.hjc.market.service.MenuService;
import pres.hjc.market.service.UserService;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  18:32
 * @description : user service
 */
@Service
@Primary
public class UserDetailsHandlerImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

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
            throw new LockedException("账户被锁定");
        }else if (usersModel.getStatus().equals(UserStatusEnum.DISABLE.getStatus())){
            throw new DisabledException("账户被注销");
        }
        UserDetail detail = new UserDetail();
        // 属性 赋值
        BeanUtils.copyProperties(usersModel,detail);
        // 查询 权限
        List<MenuModel> menuModels = menuService.queryAll();
        // set
        detail.setMenuModels(menuModels);


        return detail;
    }
}
