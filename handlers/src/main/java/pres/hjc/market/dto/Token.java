package pres.hjc.market.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/22  16:48
 * @description : token
 */
@Accessors( chain = true)
public class Token implements Serializable {

    private static final long serialVersionUID = 4627463094596435464L;

    @Getter
    @Setter
    private String token;

    /**
     * 登录时间戳
     */
    @Getter
    @Setter
    private Long longTime;

    public Token(String token, Long longTime) {
        this.token = token;
        this.longTime = longTime;
    }
}
