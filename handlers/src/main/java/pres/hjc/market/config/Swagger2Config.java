package pres.hjc.market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/2  16:59
 * @description :
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * aip 接口扫描
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "pres.qianmuna.market";

    /**
     * base version
     */
    public static final String VERSION = "1.0.0";

    /**
     * api info build
     * @return
     */
    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 暴露
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api info
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 文档标题
                .title("market")
                //文档描述
                .description("API 文档")
                // 文档版本信息
                .version(VERSION)
                //文档得 licence
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }

}
