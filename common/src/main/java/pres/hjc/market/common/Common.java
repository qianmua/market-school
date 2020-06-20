package pres.hjc.market.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  12:55
 * @description :
 */
@ToString
@NoArgsConstructor
@Accessors( chain = true)
public class Common<T> {

    /**
     * 状态码
     */
    @Getter
    @Setter
    private Integer code;

    /**
     * 响应信息
     */
    @Getter
    @Setter
    private String message;

    /**
     * 响应数据
     */
    @Getter
    @Setter
    private T data;

    /**
     * 无返回信息
     * @param code
     * @param message
     */
    public Common(Integer code , String message){
        this(code , message , null);
    }

    /**
     * 返回数据
     * @param code
     * @param message
     * @param data
     */
    public Common(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
