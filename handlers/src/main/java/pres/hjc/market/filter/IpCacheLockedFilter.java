package pres.hjc.market.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/2  14:06
 * @description :   filter
 */
@Component
@Slf4j
public class IpCacheLockedFilter implements Filter {

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
        log.info("ip filter...");
        // 刷新 cookie

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
