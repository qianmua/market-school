package pres.hjc.market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.hjc.market.mapper.MenuMapping;
import pres.hjc.market.po.MenuModel;
import pres.hjc.market.service.MenuService;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/25  12:39
 * @description :
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapping menuMapping;

    /**
     * queryAll
     * @return
     */
    @Override
    public List<MenuModel> queryAll() {
        return menuMapping.findAll();
    }
}
