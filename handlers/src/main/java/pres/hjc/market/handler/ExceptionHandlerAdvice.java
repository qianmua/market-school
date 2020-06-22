package pres.hjc.market.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pres.hjc.market.common.CommonMsg;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/22  15:48
 * @description :
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    /**
     * 参数异常
     * // 用户不存在
     * // 密码错误
     * // ..
     *  直接 抛出 当前异常
     * @param ex err
     * @return json
     */
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonMsg badRequestException(IllegalArgumentException ex){
        return new CommonMsg(HttpStatus.BAD_REQUEST.value() , ex.getMessage());
    }

    /**
     * 权限拒绝
     * @param ex 无权限
     * @return json
     */
    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonMsg badRequestException(AccessDeniedException ex){
        return new CommonMsg(HttpStatus.FORBIDDEN.value() , ex.getMessage());
    }

    /**
     * 运行错误
     * @param ex 无权限
     * @return json
     */
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonMsg badRequestException(RuntimeException ex){
        return new CommonMsg(HttpStatus.INTERNAL_SERVER_ERROR.value() , ex.getMessage());
    }


}
