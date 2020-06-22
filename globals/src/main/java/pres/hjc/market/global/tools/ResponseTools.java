package pres.hjc.market.global.tools;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/21  15:14
 * @description : 响应 信息 通过 response 封装 一个 Common
 */
public class ResponseTools {

    public static void responseJson(HttpServletResponse response , Integer status , Object data){
        try {

            /**
             * 跨域
             */
            response.setHeader("Access-Control-Allow-Origin","*");
            response.setHeader("Access-Control-Allow-Methods","*");
            // 返回json
            response.setContentType("application/json;charset=UTF-8");

            response.setStatus(status);

            response.getWriter().write(JSONObject.toJSONString(data));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
