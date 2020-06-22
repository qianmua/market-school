package pres.hjc.market.tools;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pres.hjc.market.impl.UserDetail;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/22  20:21
 * @description :
 */
public class UserUtil {

    public static UserDetail getLoginUsers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication!= null? (UserDetail) authentication.getDetails() : null;
    }
}
