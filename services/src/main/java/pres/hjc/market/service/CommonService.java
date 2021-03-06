package pres.hjc.market.service;

import pres.hjc.market.common.CommonMsg;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  18:03
 * @description :
 */
public interface CommonService<T> {

    /**
     * queryAll
     * @return query
     */
    CommonMsg<T> queryAll();

    /**
     * query by id
     * @param id
     * @return
     */
    CommonMsg<T> queryById(Long id);

    /**
     * query by Name
     * @param name
     * @return
     */
    CommonMsg<T> queryByName(String name);




}
