package pers.hjc.market.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import pres.hjc.market.po.RoleModel;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  15:52
 * @description :
 */
public interface RoleMapping extends JpaRepository<RoleModel , Long> {
}
