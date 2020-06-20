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
 * @date 2020/6/20  13:27
 * @description : 物品
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "goods")
public class GoodsModel {

    @Id
    @GeneratedValue
    private Long gid;
    private String gName;
    private String gPrice;
    /** 描述 */
    private String describe;
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
