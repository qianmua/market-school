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
 * @date 2020/6/20  13:25
 * @description : 权限
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "auth")
public class AuthModel {

    @Id
    @GeneratedValue
    private Long aid;
    private String aName;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;
    private Integer status;
}
