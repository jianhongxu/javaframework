package com.xjh.myspringboot.exceptionhander;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor xujianhong
 * @date 2020/2/3 19:28
 */

@ControllerAdvice
public class MyExceptionHandler {


    /**
     * 浏览器和客户端都是返回json数据
     * @param e
     * @return
     */
   /* @ResponseBody
    @ExceptionHandler({MyExcepiton.class})
    public Object handMyException(Exception e){
        Map<String, Object> result = new HashMap<>();
        result.put("code","code.40122");
        result.put("excepiton", e.getMessage());
        return result;

    }*/


    /**
     * 返回结果自适应  浏览器和json
     * @param e
     * @return
     */
    @ExceptionHandler({MyExcepiton.class})
    public String handMyExceptionTwo(Exception e, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        result.put("code","code.40122");
        result.put("excepiton", e.getMessage());
        request.setAttribute("ext",result);

        //传入我们自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code",6000);



        return "forward:/error";

    }
}
