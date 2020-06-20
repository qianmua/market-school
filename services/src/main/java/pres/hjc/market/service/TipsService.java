package pres.hjc.market.service;

import pres.hjc.market.po.TipsModel;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  16:58
 * @description :
 */
public interface TipsService {

    /**
     * query all
     * @return list
     */
    List<TipsModel> queryAll();

    /**
     * add
     * @param tipsModel
     */
    void addTips(TipsModel tipsModel);

    /**
     * update
     * @param tipsModel
     */
    void updateTips(TipsModel tipsModel);

    /**
     * delete
     * @param tid
     */
    void deleteTipsById(Long tid);

}
