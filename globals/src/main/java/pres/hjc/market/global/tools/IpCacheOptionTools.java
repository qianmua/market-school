package pres.hjc.market.global.tools;

import org.springframework.stereotype.Component;
import pres.hjc.market.dto.IpCacheEntity;
import pres.hjc.market.global.ApiResponse;
import pres.hjc.market.global.cache.IpCacheQueue;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/26  17:56
 * @description :
 */
@Component
public class IpCacheOptionTools extends IpCacheQueue {

    /**
     * 最大请求次数
     */
//    @Value("10")
    private Integer MAX_REQUEST_SIZE = 3;

    /**
     * 过期时间
     */
//    @Value("")
    private Long TIME_END = 600_000L;

    /**
     * add lock
     * @param request
     * @return
     */
    public boolean addIpCache(HttpServletRequest request){
        String ip = getLockIp(request);
        IpCacheEntity value = getValue(ip);
        if (value!= null){
            if (!value.isLocked()){
                if (value.getSize() >= MAX_REQUEST_SIZE){
                    return putIp(ip , true);
                }else {
                    return putIp(ip , false);
                }
            }
            /*if (isEndLock(request)){
                return deleteKey(ip);
            }*/
        }else {
            return putIp(ip , false);
        }
        return false;
    }

    /**
     * unlock
     * @param request
     * @return
     */
    public boolean deleteCache(HttpServletRequest request){
        String ip = getLockIp(request);
        return deleteKey(ip);
    }

    /**
     * 验证过期
     * @param request
     * @return
     */
    public boolean isEndLock(HttpServletRequest request){

        String ip = getLockIp(request);
        IpCacheEntity value = getValue(ip);
        if (value!= null){
            long l = value.getStartTime() + TIME_END;
            if (l <= System.currentTimeMillis()){
                return deleteKey(ip);
            }
        }
        return false;
    }

    /**
     * is locked
     * @param request
     * @return
     */
    public boolean isLocked(HttpServletRequest request){
        String ip = getLockIp(request);
        IpCacheEntity value = getValue(ip);
        return value != null && value.isLocked();
    }

    /**
     * get ip
     * @param request
     * @return
     */
    private String getLockIp(HttpServletRequest request){
        return ApiResponse.analysisIp(request);
    }






}
