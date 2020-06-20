package pres.hjc.market.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.hjc.market.po.TipsModel;
import pres.hjc.market.service.TipsService;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  17:29
 * @description :
 */
@RestController
@RequestMapping("/admin/tips")
public class AdminTipsController {

    @Autowired
    private TipsService tipsService;

    @GetMapping("/save")
    public String save(){
        TipsModel tipsModel = new TipsModel();
        tipsModel.setTName("777777");
        tipsService.addTips(tipsModel);

        return "SUCCESS";
    }
}
