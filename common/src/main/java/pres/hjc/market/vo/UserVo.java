package pres.hjc.market.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  15:49
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo {

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

    private List<RoleVo> role;
}
