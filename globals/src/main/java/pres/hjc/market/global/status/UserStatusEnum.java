package pres.hjc.market.global.status;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  14:20
 * @description :
 */
public enum UserStatusEnum {
    /**
     * 正常
     */
    OK(0),
    /**
     * 无信息
     */
    NOT_FOUND(1),
    /**
     * 错误用户
     */
    ERROR(4),
    /**
     * 锁定
     */
    LOCKDE(5),
    /**
     * 解锁
     */
    UN_LOCKDE(6),

    ;


    private Integer status;

    UserStatusEnum(Integer status) {
        this.status = status;
    }
}
