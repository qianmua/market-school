package pres.hjc.market.po;

import lombok.Data;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:25
 * @description : 权限
 */
@Data
public class AuthModel {

    private Long aid;
    private String aName;
    private Long rid;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;
    private Integer status;
}
