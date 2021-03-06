package pres.hjc.market.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import pres.hjc.market.common.CommonMsg;
import pres.hjc.market.dto.Token;
import pres.hjc.market.filter.TokenFilter;
import pres.hjc.market.global.status.UserStatusEnum;
import pres.hjc.market.global.tools.IpCacheOptionTools;
import pres.hjc.market.global.tools.ResponseTools;
import pres.hjc.market.dto.UserDetail;
import pres.hjc.market.service.TokenService;
import pres.hjc.market.tools.UserUtil;

import javax.servlet.http.HttpServletRequest;


/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  14:38
 * @description :
 */
@Configuration
@Slf4j
public class SecurityConfigHandler {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private IpCacheOptionTools ipCacheOptionTools;

    /**
     * 登录成功 返回token
     * @return
     */
    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return (httpServletRequest, httpServletResponse, authentication) -> {
            //user
            UserDetail details = (UserDetail) authentication.getPrincipal();
            // 根据user 生成token
            Token token = tokenService.saveToken(details);

            ResponseTools.responseJson(httpServletResponse, HttpStatus.OK.value() , token);

        };
    }

    /**
     * 登录失败
     * @return
     */
    @Bean
    public AuthenticationFailureHandler failureHandler(){
        return (httpServletRequest, httpServletResponse, exception) -> {
            String msg = "";
            if (exception instanceof BadCredentialsException){
                msg = "密码错误";
                boolean locked = ipCacheOptionTools.isLocked(httpServletRequest);
//                System.out.println(locked);
//                System.out.println(ipCacheOptionTools.getIpCache());
//                log.info(ipCacheOptionTools.getIpCache().toString());
                if (!locked){
                    boolean b = ipCacheOptionTools.addIpCache(httpServletRequest);
                }else {
                    msg = "locked after 10 min again..";
                    // 不用 从 ip 登录 中 得到 值
                    // 未登录呐
                    // 直接 锁定 cookie 就可以了
                    /*UserDetail detail = UserUtil.getLoginUsers();
                    if (ipCacheOptionTools.isEndLock(httpServletRequest)){
                        ipCacheOptionTools.deleteCache(httpServletRequest);
                        if (detail != null){
                            detail.setStatus(UserStatusEnum.UN_LOCKDE.getStatus());
//                            userDetailsManager.updateUser(detail);
                            // 新的 用户
//                            new UsernamePasswordAuthenticationToken();
//                            SecurityContextHolder.getContext().setAuthentication();
                        }
                        log.info("unlocked");
                    }
                    if (detail != null){
                        detail.setStatus(UserStatusEnum.LOCKDE.getStatus());
//                        userDetailsManager.updateUser(detail);
                        log.warn("user -> locked");
                    }*/
                }
            }else {
                msg = exception.getMessage();
            }
            // return info
            CommonMsg commonMsg = new CommonMsg();
            commonMsg.setMessage(msg).setCode(HttpStatus.UNAUTHORIZED.value());

            ResponseTools.responseJson(httpServletResponse,HttpStatus.UNAUTHORIZED.value() , commonMsg);
        };
    }

    /**
     * 未登录 401 状态码
     * @return
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return (req,res,authExc) -> {
            // 401
            // return info

            // ajax 验证
            if (isAjaxRequest(req)){
                CommonMsg commonMsg = new CommonMsg();
                commonMsg.setMessage("请登录").setCode(HttpStatus.UNAUTHORIZED.value());
                ResponseTools.responseJson(res,HttpStatus.UNAUTHORIZED.value() , commonMsg);
            }else {
                res.sendRedirect("/home/login.html");
            }
        };
    }

    /**
     * ajax ?
     * @param request
     * @return
     */
    private static boolean isAjaxRequest(HttpServletRequest request){
        String header = request.getHeader("X-Requested-With");
        return header != null && "XMLHttpRequest".equals(header);
    }

    /**
     * 退出 登录
     * @return
     */
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler(){
        return (req,res,authentication)-> {
            // 编辑信息
            CommonMsg commonMsg = new CommonMsg();
            commonMsg.setMessage("退出成功").setCode(HttpStatus.OK.value());
            // 退出成功 清理 token
            // 从过滤器中 取出token
            String token = TokenFilter.getToken(req);
            tokenService.removeToken(token);
            // 返回状态码
            ResponseTools.responseJson(res,HttpStatus.OK.value() , commonMsg);

        };
    }



}
