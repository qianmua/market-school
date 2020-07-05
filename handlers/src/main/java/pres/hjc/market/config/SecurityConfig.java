package pres.hjc.market.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import pres.hjc.market.filter.TokenFilter;
import pres.hjc.market.global.global.SecurityVal;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  14:25
 * @description :
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    @Autowired
    private AuthenticationEntryPoint entryPoint;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TokenFilter tokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        //基于token 不用session
        // 基于session 就不用 配置
        //
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers(SecurityVal.antMatchers).permitAll().anyRequest().authenticated();
        // 添加 handler
        http.formLogin()
                .loginPage("/home/login.html")
                .loginProcessingUrl("/login")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                .exceptionHandling()
                //  注意 当前 未登录 会 返回 json 串
                //过滤掉 页面 转发
                // 补充 自定义
                // 判断 ajax 还是 页面 跳转哦
                .authenticationEntryPoint(entryPoint);

        http.logout()
                .logoutUrl("/logout.html")
                .logoutSuccessUrl("/login.html")
                .logoutSuccessHandler(logoutSuccessHandler);

        // remember me
        /*http.rememberMe()
                .tokenRepository()
                .tokenValiditySeconds()
                .userDetailsService(userDetailsService);*/

        // iframe 不允许显示问题
        http.headers().frameOptions().disable();
        http.headers().cacheControl();

        // 拦截 请求 得到token
        // 对token 校验
        // 老报 error
        //。。。。
        http.addFilterBefore(tokenFilter , UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * token 生成
     * @return token service
     */
    /*@Bean
    public KeyBasedPersistenceTokenService tokenService(){
        return new KeyBasedPersistenceTokenService();
    }*/


    /**
     * 登录逻辑
     * @param auth auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    /**
     * 密码校验规则
     * @return p
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 资源放行
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }
}
