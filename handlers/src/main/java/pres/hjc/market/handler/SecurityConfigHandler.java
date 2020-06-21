package pres.hjc.market.handler;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import pres.hjc.market.global.tools.ResponseTools;
import pres.hjc.market.impl.UserDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  14:38
 * @description :
 */
@Configuration
public class SecurityConfigHandler {
    @Autowired
    private TokenService tokenService;

    /**
     * 登录成功 返回token
     * @return
     */
    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return (httpServletRequest, httpServletResponse, authentication) -> {
            //user
            UserDetail details = (UserDetail) authentication.getDetails();

            // 根据user 生成token
            Token token = null;
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
            }else {
                msg = exception.getMessage();
            }

            // return info

            ResponseTools.responseJson(httpServletResponse,HttpStatus.UNAUTHORIZED.value() , msg);
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
            ResponseTools.responseJson(res,HttpStatus.UNAUTHORIZED.value() , "login");

        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler(){
        return (req,res,authentication)-> {
            // 编辑信息

            // 退出成功 清理 token
            // 返回状态码
            ResponseTools.responseJson(res,HttpStatus.OK.value() , "退出成功");

        };
    }



}
