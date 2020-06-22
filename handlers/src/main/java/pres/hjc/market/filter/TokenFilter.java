package pres.hjc.market.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import pres.hjc.market.impl.UserDetail;
import pres.hjc.market.service.TokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/22  19:49
 * @description : token filter
 */
@Component
public class TokenFilter extends OncePerRequestFilter {

    private static final String TOKEN_KEY = "token";
    /**
     * 阈值
     */
    private static final Long MINUTES_10 = 10 * 60 * 1000L;

    @Autowired
    TokenService tokenService;

    /**
     * 过滤规则
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        if (!StringUtils.isEmpty(token)){
            UserDetail loginUser = tokenService.getLoginUser(token);
            if (loginUser != null){
                //检查
                loginUser = checkLoginTime(loginUser);

                UsernamePasswordAuthenticationToken token1 = new UsernamePasswordAuthenticationToken(loginUser,
                        null, loginUser.getAuthorities());
                // 凭证 设置到框架 上下文
                SecurityContextHolder.getContext().setAuthentication(token1);

            }
        }

        filterChain.doFilter(request,response);
    }

    /**
     * get token for header
     * @param request
     * @return
     */
    private static String getToken(HttpServletRequest request){
        // 参数里面获得
        String token = request.getParameter(TOKEN_KEY);
        if (StringUtils.isEmpty(token)){
            // 头信息里面获取
            return request.getHeader(TOKEN_KEY);
        }
        return token;
    }

    /**
     * 用户信息 检查
     * @param userDetail
     * @return
     */
    private UserDetail checkLoginTime(UserDetail userDetail){
        Long expireTime = userDetail.getExpireTime();
        long millis = System.currentTimeMillis();
        if (expireTime - millis <= MINUTES_10){
            String token = userDetail.getToken();
            //service
            // 检查 登录时间
        }

        return userDetail;
    }
}
