package pres.hjc.market.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.hjc.market.common.CommonMsg;
import pres.hjc.market.mapper.TipsMapping;
import pres.hjc.market.po.TipsModel;
import pres.hjc.market.service.TipsService;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  17:16
 * @description :
 */
@Service
@Slf4j
public class TipsServiceImpl implements TipsService {

    @Autowired
    private TipsMapping tipsMapping;


    @Override
    public List<TipsModel> queryTips() {
        return tipsMapping.findAll();
    }

    @Override
    public void addTips(TipsModel tipsModel) {
        tipsMapping.save(tipsModel);
    }

    @Override
    public void updateTips(TipsModel tipsModel) {
        tipsMapping.save(tipsModel);
    }

    @Override
    public void deleteTipsById(Long tid) {
        tipsMapping.deleteById(tid);
    }

}
