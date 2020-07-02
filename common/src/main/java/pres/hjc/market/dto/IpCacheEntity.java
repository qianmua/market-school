package pres.hjc.market.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/26  18:52
 * @description : dto ip cache
 */
@Accessors(chain = true)
@ToString
public class IpCacheEntity implements Serializable {

    private static final long serialVersionUID = 6103498266008037902L;

    @Getter
    @Setter
    private Integer size;

    @Getter
    @Setter
    private Long startTime;

    @Getter
    @Setter
    private boolean locked;

    public IpCacheEntity(Integer size, Long startTime) {
        this.size = size;
        this.startTime = startTime;
    }



}
