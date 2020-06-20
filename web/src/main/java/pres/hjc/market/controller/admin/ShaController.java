package pres.hjc.market.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pres.hjc.market.global.SHAUtil;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  20:03
 * @description :
 */
@Controller
@RequestMapping("/admin/md5")
public class ShaController {

    @GetMapping("/page")
    public String getPage(){

        //admin/md5/pages
        //G139353F

        return "admin/md5";
    }


    @PostMapping("/pages")
    public String md(String md , Model model){
        String str = SHAUtil.encreptUrl(md);
        model.addAttribute("origin" , md);
        model.addAttribute("md" , str);
        return "admin/md5";
    }

}
