package pres.hjc.market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pres.hjc.market.mapper.MenuMapping;
import pres.hjc.market.po.MenuModel;
import pres.hjc.market.service.MenuService;

import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional( rollbackFor = RuntimeException.class)
    public void deleteMenuById(Long id) {
        Optional<MenuModel> byId = menuMapping.findById(id);
        if (byId.isPresent()){
            menuMapping.deleteById(id);
        }
    }
}
