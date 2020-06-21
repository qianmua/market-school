package pres.hjc.market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.hjc.market.common.CommonMsg;
import pres.hjc.market.mapper.TipsMapping;
import pres.hjc.market.po.TipsModel;
import pres.hjc.market.service.CommonService;
import pres.hjc.market.service.process.CommonProcess;


/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  18:22
 * @description :
 */
@Service
public class TipServiceImpl<T> implements CommonService<T> {

    @Autowired
    private TipsMapping tipsMapping;

    @Override
    public CommonMsg<T> queryAll() {
        return new CommonProcess().commonMessageFactoryProcess(tipsMapping.findAll());
    }

    @Override
    public CommonMsg<T> queryById(Long id) {
        return null;
    }

    @Override
    public CommonMsg<T> queryByName(String name) {
        return null;
    }

}
