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
 * @date 2020/6/20  16:55
 * @description : 标签
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "tips")
public class TipsModel {

    @Id
    @GeneratedValue
    private Long tid;
    @Column( nullable = false , unique = true ,length = 100)
    private String tName;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;

    private Integer status;
}
