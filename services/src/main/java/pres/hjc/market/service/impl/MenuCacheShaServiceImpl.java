package pres.hjc.market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.hjc.market.mapper.MenuCacheMapping;
import pres.hjc.market.po.MenuCacheShaModel;
import pres.hjc.market.service.MenuCacheShaService;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/25  13:05
 * @description :
 */
@Service
public class MenuCacheShaServiceImpl implements MenuCacheShaService {

    @Autowired
    private MenuCacheMapping menuCacheMapping;

    /**
     * query all
     * @return
     */
    @Override
    public List<MenuCacheShaModel> queryAll() {
        return menuCacheMapping.findAll();
    }
}
