package pres.hjc.market.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:17
 * @description : 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "userInfo")
public class UsersModel {

    /**
     * 主键 生成io
     */
    @Id
    @GeneratedValue
    private Long uid;
    @Column( nullable = false , unique = true ,length = 36)
    private String userName;
    @Column( nullable = false , length = 20)
    private String password;
    private String realName;
    private String nickName;
    private String headImgUrl;
    private String birthday;
    private String tel;
    private String email;

    private Long rid;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;

    private Integer status;



}
