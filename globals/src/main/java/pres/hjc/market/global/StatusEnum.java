package pres.hjc.market.global;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  12:59
 * @description :
 */
public enum StatusEnum {
    /**
     * not found
     */
    NOT_FOUND(404),
    /**
     * service error
     */
    DATA_ERROR(500),
    /**
     * success
     */
    SUCCESS(200),
    /**
     * auth not found
     */
    NO_AUTH(403),
    ;



    private Integer status;

    StatusEnum(Integer status) {
        this.status = status;
    }
}

