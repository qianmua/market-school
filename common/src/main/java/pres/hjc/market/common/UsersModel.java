package pres.hjc.market.common;

import lombok.Data;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:17
 * @description : 用户
 */
@Data
public class UsersModel {

    private Long uid;
    private String userName;
    private String password;
    private String realName;
    private String tel;
    private String email;


    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;

    private Integer status;



}
