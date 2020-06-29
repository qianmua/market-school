package pres.hjc.market.service.impl;

import org.springframework.stereotype.Service;
import pres.hjc.market.common.CommonMsg;
import pres.hjc.market.mapper.UserMapping;
import pres.hjc.market.po.UsersModel;
import pres.hjc.market.service.UserService;

import javax.annotation.Resource;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  18:36
 * @description : impl
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapping userMapping;


    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UsersModel queryByUserName(String userName) {
        return userMapping.queryByUserName(userName);
    }

    @Override
    public CommonMsg updateUserInfo(UsersModel usersModel) {
        if (usersModel != null && usersModel.getUid() != null){
            UsersModel save = userMapping.save(usersModel);
            return new CommonMsg<>(200,"" , save);
        }
        return new CommonMsg(500,"非法参数");
    }
}
