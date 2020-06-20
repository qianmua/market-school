package pres.hjc.market.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import pres.hjc.market.po.TipsModel;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  17:21
 * @description :
 */
public interface TipsMapping extends JpaRepository<TipsModel , Long> {
}
