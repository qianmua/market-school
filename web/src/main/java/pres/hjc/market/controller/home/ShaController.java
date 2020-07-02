package pres.hjc.market.controller.home;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.hjc.market.global.cache.UriCacheMap;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/29  14:54
 * @description :
 */
@RestController(value = "homeShaController")
@RequestMapping("/info")
public class ShaController {

    @GetMapping("/type/{sha}")
    public String type(@PathVariable String sha){
        if (!StringUtils.isEmpty(sha) && !UriCacheMap.isEmpityMap()){
            String value = UriCacheMap.getValue(sha);
            return "data";
        }
        // hash // 404
        return null;
    }
}
