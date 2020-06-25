package pres.hjc.market.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pres.hjc.market.po.MenuCacheShaModel;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/25  13:04
 * @description :
 */
@Repository
public interface MenuCacheMapping extends JpaRepository<MenuCacheShaModel , Long> {
}
