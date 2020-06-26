package pres.hjc.market.global;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:05
 * @description :
 */
public class ApiResponse {

    /**
     * 解析 ip 并且 return
     * @param request
     * @return
     */
    public static String analysisIp(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();

    }
}
