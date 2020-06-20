package pers.hjc.market.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import pres.hjc.market.po.UsersModel;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:43
 * @description :
 */
public interface UserMapping extends JpaRepository<UsersModel, Long> {
}
