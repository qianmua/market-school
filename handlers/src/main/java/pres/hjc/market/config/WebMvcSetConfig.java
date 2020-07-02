package pres.hjc.market.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pres.hjc.market.filter.IpCacheLockedFilter;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/29  14:34
 * @description : web config
 */
@Configuration
public class WebMvcSetConfig implements WebMvcConfigurer {

    @Autowired
    private IpCacheLockedFilter lockedFilter;

    /**
     * filter
     * //如果有多个Filter，
     * 再写一个public FilterRegistrationBean registerOtherFilter(){...}。
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<IpCacheLockedFilter> registrationBean(){
        FilterRegistrationBean<IpCacheLockedFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(lockedFilter);
        bean.addUrlPatterns("/*");
        bean.setName("ipCache");
        // 排序
        bean.setOrder(2);
        return bean;
    }

    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }



}
