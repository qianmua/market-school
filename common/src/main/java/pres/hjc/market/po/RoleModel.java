package pres.hjc.market.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  13:24
 * @description : 角色
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "roles")
public class RoleModel {

    @Id
    @GeneratedValue
    private Long rid;
    private String rName;
    private Long aid;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;
    private Integer status;

}
