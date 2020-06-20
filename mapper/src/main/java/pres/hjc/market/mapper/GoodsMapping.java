package pres.hjc.market.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import pres.hjc.market.po.GoodsModel;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  17:51
 * @description :
 */
public interface GoodsMapping extends JpaRepository<GoodsModel , Long> {
}
