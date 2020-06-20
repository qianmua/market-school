package pres.hjc.market.common;

import lombok.Data;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:27
 * @description : 物品
 */
@Data
public class GoodsModel {

    private Long gid;
    private String gName;
    private String gPrice;
    /** 描述 */
    private String desc;
    private Integer hot;
    private String url;

    private Long uid;
    private Long tid;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;
    private Integer status;
}
