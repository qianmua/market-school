package pres.hjc.market.global.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  20:17
 * @description : 短地址 加密
 */
public final class UriCacheMap {

    private static Map<String , String > uriCache = new HashMap<>(10);

    /**
     * put
     * @param uri u
     * @param sha p
     * @return u
     */
    public static String putValue(String uri , String sha){
        return uriCache.put(uri, sha);
    }

    /**
     * has
     * @param sha k
     * @return v
     */
    public static boolean hasUri(String sha){
        return uriCache.containsKey(sha);
    }

    /**
     * get
     * @param sha k
     * @return v
     */
    public static String getValue(String sha){
        return (uriCache.size() == 0) ? null : uriCache.get(sha);
    }

    /**
     * get key
     * @return set key
     */
    public static Set getKey(){
        return uriCache.keySet();
    }

    /**
     * get value
     * @return set value
     */
    public static Set getValue(){
        return new HashSet<>(uriCache.values());
    }

    /**
     * 空 map
     * @return
     */
    public static boolean isEmpityMap(){
        return uriCache.size() == 0;
    }

}
