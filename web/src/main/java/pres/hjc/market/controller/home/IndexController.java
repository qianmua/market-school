package pres.hjc.market.controller.home;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api( tags = {"home/base"})
public class IndexController {


    @GetMapping("index.html")
    public String index(){
        return "index";
    }

    @ApiOperation( value = "login" , notes = "login" , produces = "application/json")
    @GetMapping("login.html")
    public String login(){ return "home/login";}

}
