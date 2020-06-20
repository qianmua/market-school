package pres.hjc.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:39
 * @description :
 */
@SpringBootApplication( scanBasePackages = {"pres.hjc.market"})
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run( MarketApplication.class , args);
    }
}
