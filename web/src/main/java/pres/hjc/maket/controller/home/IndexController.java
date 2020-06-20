package pres.hjc.maket.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:41
 * @description :
 */
@Controller
@RequestMapping("/home")
public class IndexController {


    @GetMapping("index")
    public String index(){
        return "index";
    }

}
