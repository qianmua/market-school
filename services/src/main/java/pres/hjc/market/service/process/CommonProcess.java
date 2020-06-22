package pres.hjc.market.service.process;

import pres.hjc.market.common.CommonMsg;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  18:08
 * @description :
 */
public class CommonProcess<T> {

    public CommonMsg<T> commonMessageFactoryProcess(T data){
        CommonMsg<T> msg = new CommonMsg<>();
        msg.setCode(200)
                .setMessage("")
                .setData(data);

        return msg;
    }

}
