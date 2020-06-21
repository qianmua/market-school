package pres.hjc.market.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  13:34
 * @description : druid config
 */
@Configuration
public class DruidConfig {

    /**
     * config
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druid(){
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // ip 白名单
        registrationBean.addInitParameter("allow" , "127.0.0.1");
        // ip 黑名单
//        registrationBean.addInitParameter("deny" , "000");
        // 控制台用户
        registrationBean.addInitParameter("loginUsername" , "qianmuna");
        registrationBean.addInitParameter("loginPassword" , "qianmuna");

        return registrationBean;
    }

    /**
     * 过滤 规则
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions" , "*.js,*.gif,*.phg,*.css,*.ico,/druid/*");

        return bean;

    }

}
