package pres.hjc.market.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;
import pres.hjc.market.po.AuthModel;

import java.util.List;


/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  15:43
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder( value = {"rName"})
public class RoleVo {

    @JsonIgnore
    private Long rid;

    private String rName;
    private Long uid;

    private String createDate;
    private String updateDate;
    private Long createId;
    private Long updateId;
    private Integer status;

    private List<AuthModel> auth;




}
