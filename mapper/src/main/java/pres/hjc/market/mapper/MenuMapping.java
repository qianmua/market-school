package pres.hjc.market.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pres.hjc.market.po.MenuModel;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/25  12:38
 * @description :
 */
@Repository
public interface MenuMapping extends JpaRepository<MenuModel  , Long> {
}
