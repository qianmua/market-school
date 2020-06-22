package pres.hjc.market.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
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

    /**
     * get page
     * @return view
     */
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('sys:url:create')")
    public String getPage(){

        //admin/md5/pages
        //G139353F

        return "admin/md5";
    }


    @PostMapping("/pages")
    @PreAuthorize("hasAuthority('sys:url:create')")
    public String md(String md , Model model){
        String str = SHAUtil.encreptUrl(md);
        model.addAttribute("origin" , md);
        model.addAttribute("md" , str);
        return "admin/md5";
    }

}
