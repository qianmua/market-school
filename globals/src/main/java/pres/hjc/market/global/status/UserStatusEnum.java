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
    OK(0 , "SUCCESS"),
    /**
     * 无信息
     */
    NOT_FOUND(1,"NOT FOUND"),
    /**
     * 错误用户
     */
    ERROR(4,"ERROR USER"),
    /**
     * 锁定
     */
    LOCKDE(5 , "LOCKED"),
    /**
     * 解锁
     */
    UN_LOCKDE(6 , "UNLOCKED"),

    DISABLE(7 , "LOGOUT"),

    ;

    private Integer status;
    private String msg;

    UserStatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
