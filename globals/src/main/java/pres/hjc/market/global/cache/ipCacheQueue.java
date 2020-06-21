package pres.hjc.market.global.cache;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  20:37
 * @description :  ip 队列
 */
public class ipCacheQueue {

    /**
     * 维护黑名单 ip 队列
     */
    private static Queue<String> ipKillCache = new LinkedBlockingQueue<>();


}
