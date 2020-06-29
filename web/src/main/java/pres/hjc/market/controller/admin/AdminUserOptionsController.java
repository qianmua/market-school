package pres.hjc.market.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.hjc.market.common.CommonMsg;
import pres.hjc.market.po.UsersModel;
import pres.hjc.market.service.UserService;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/29  14:43
 * @description : user options
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserOptionsController {

    @Autowired
    private UserService userService;

    /**
     * user Change
     * @param usersModel
     * @return
     */
    @PostMapping("/changePassword")
    public CommonMsg changeUser(UsersModel usersModel){

        CommonMsg commonMsg = userService.updateUserInfo(usersModel);

        return commonMsg;
    }

}
