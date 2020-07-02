package pres.hjc.market.global.status;


/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  12:59
 * @description : http status
 */
public enum HttpStatusEnum {
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
    /**
     * 未登录
     */
    NO_LOGIN(401),
    ;



    private Integer status;

    HttpStatusEnum(Integer status) {
        this.status = status;
    }
}

