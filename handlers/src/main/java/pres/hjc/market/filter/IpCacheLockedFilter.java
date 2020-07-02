package pres.hjc.market.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Component;
import pres.hjc.market.dto.IpCacheEntity;
import pres.hjc.market.global.status.Dictionaries;
import pres.hjc.market.global.tools.CookieTools;
import pres.hjc.market.global.tools.IpCacheOptionTools;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/2  14:06
 * @description : ip filter 功能: 添加 cookie
 */
@Component
@Slf4j
public class IpCacheLockedFilter implements Filter {

    @Autowired
    private IpCacheOptionTools ipCacheOptionTools;

    /**
     * init and destroy
     * @param servletRequest    req
     * @param servletResponse   res
     * @param filterChain   阀门
     * @throws IOException  err
     * @throws ServletException er
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("ip filter...");
        // 锁定 cookie
        String cookie = CookieTools.getCookie(request, Dictionaries.COOKIE_IP_CACHE_NAME);
        // 得到 锁
        //locked or unlocked    ?
        if (ipCacheOptionTools.isLocked(request)){
            // get lock ip
            String lockIp = ipCacheOptionTools.getLockIp(request);
            log.info("locked: " + lockIp );
            // get entity (locked info)
            // map <ip , entity>
            IpCacheEntity ipCacheEntity = ipCacheOptionTools.getValue(lockIp);
            // 刷新 cookie
            if (StringUtils.isEmpty(cookie)){
                // 空 cookie
                // 添加 并刷新声明周期
                // 单位 s
                // value 时间戳
                CookieTools.setCookie(response , Dictionaries.COOKIE_IP_CACHE_NAME , ipCacheEntity.getStartTime() + "" , 60 * 10);
            }
            // 存在 cookie

            // 最终 处理
            //log.info(" 锁定 抛出 异常-> ");
            //throw new LockedException("after 10 min again.");
        }else {
            log.info("un locked..");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
