package pres.hjc.market.controller.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.hjc.market.common.CommonMsg;
import pres.hjc.market.po.TipsModel;
import pres.hjc.market.service.CommonService;
import pres.hjc.market.service.TipsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  18:00
 * @description : home
 */
@RestController
@RequestMapping("/home/tips")
public class TipsController {
    @Resource
    private TipsService tipsService;
    @Resource
    private CommonService<TipsModel> commonService;

    @GetMapping("/queryTips")
    public List<TipsModel> queryTips(){
        return tipsService.queryTips();
    }

    @GetMapping("/query")
    public CommonMsg query(){
        return commonService.queryAll();
    }
}
