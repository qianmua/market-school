package pres.hjc.market.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import pres.hjc.market.global.status.UserStatusEnum;
import pres.hjc.market.po.MenuModel;
import pres.hjc.market.po.UsersModel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  18:53
 * @description :
 */
public class UserDetail extends UsersModel implements UserDetails {

    private static final long serialVersionUID = 3841374973282074196L;


    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private Long loginLong;

    @Getter
    @Setter
    private Long expireTime;

    @Getter
    @Setter
    private List<MenuModel> menuModels;


    /**
     * 得到权限
     * @return set
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return menuModels.parallelStream().filter( v -> !StringUtils.isEmpty(v.getMName()))
                .map(v -> new SimpleGrantedAuthority(v.getMName())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    /**
     * 账户 未过期？
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 锁定？
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return super.getStatus().equals(UserStatusEnum.LOCKDE.getStatus());
    }

    /**
     * 密码未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户激活？
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
