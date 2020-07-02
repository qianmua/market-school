package pres.hjc.market.global.cache;


import org.springframework.util.StringUtils;
import pres.hjc.market.dto.IpCacheEntity;
import pres.hjc.market.global.PublicTools;

import java.util.HashMap;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  20:37
 * @description :  ip 队列
 */
public class IpCacheQueue {

    /**
     * 维护黑名单 ip 队列
     */
    private static HashMap<String, IpCacheEntity> ipCache = new HashMap<>(10);

    /**
     * get
     * @return
     */
    public HashMap<String, IpCacheEntity> getIpCache() {
        return ipCache;
    }

    /**
     * set new Value
     * @param ipCache this has map
     */
    protected void setIpCache(HashMap<String, IpCacheEntity> ipCache) {
        //
        IpCacheQueue.ipCache = ipCache;
    }

    /**
     * put
     * @param ip
     */
    protected boolean putIp(String ip , boolean locked){
        IpCacheEntity value = getValue(ip);
        if (value != null){
            value.setSize(value.getSize()+1);
            if (!locked){
                value.setStartTime(-1L).setLocked(false);
            }else {
                value.setStartTime(PublicTools.getLocalTime()).setLocked(true);
            }
            ipCache.put(ip,value);
        }else {
            ipCache.put(ip,new IpCacheEntity(0, -1L));
        }
        return true;
    }

    /**
     * get v
     * @param ip
     * @return
     */
    public IpCacheEntity getValue(String ip){
        if (ipIsEmpty(ip)){
            return null;
        }
        return ipCache.get(ip);
    }

    /**
     * 当前封锁时间
     * @param ip
     * @return
     */
    protected Long getEndTime(String ip){
        IpCacheEntity value = getValue(ip);
        if (value!= null){
            return value.getStartTime();
        }
        return -1L;
    }

    /**
     * 当前 ip 是否存在cache
     * @return t f
     */
    protected boolean ipIsEmpty(String ip){
        if (!StringUtils.isEmpty(ip)){
            return !ipCache.containsKey(ip);
        }
        return false;
    }

    /**
     * 移除 指定key
     * @param ip
     * @return
     */
    @Deprecated
    protected boolean deleteKey(String ip,Integer max){
        if (!StringUtils.isEmpty(ip)){
            if (!ipCache.containsKey(ip)){
                return ipCache.remove(ip, null);
            }
        }
        return false;
    }

    /**
     * 默认 3
     * @param ip
     * @return
     */
    protected boolean deleteKey(String ip){
        if (ipIsEmpty(ip)){
            ipCache.remove(ip);
            return true;
        }
        return false;
    }



}
