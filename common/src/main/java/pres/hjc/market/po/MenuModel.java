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
 * @date 2020/6/21  14:05
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "menu")
public class MenuModel {

    @Id
    @GeneratedValue
    private Long mid;
    /**
     * 菜单 级别
     *  树形结构
     */
    private Integer parentId;
    private String mName;
    private String cssStyle;
    private String hrefMenu;
    /**
     * 1 or 2 ; 按钮 或者 跳转路径
     */
    private Integer type;

    /**
     * 权限标识
     * sys:user:query
     * sys:user:add
     * sys:menu:add
     * sys:role:query
     * .....
     * job..
     * mail..
     */
    private Long aid;

    private Integer sort;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;

    private Integer status;


}
