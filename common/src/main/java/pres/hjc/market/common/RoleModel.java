package pres.hjc.market.common;

import lombok.Data;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:24
 * @description : 角色
 */
@Data
public class RoleModel {

    private Long rid;
    private String rName;
    private Long uid;


    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;
    private Integer status;
}
