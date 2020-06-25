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
 * @date 2020/6/25  12:50
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "MenuCacheSha")
public class MenuCacheShaModel {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long mCacheId;
    @Column( nullable = false)
    private String mShaKey;
    @Column( nullable = false)
    private String mShaValue;

    /**
     * 权限菜单
     */
    private Long aid;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;
}
