package com.xjh.myspringboot.exceptionhander;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @autor xujianhong
 * @date 2020/2/3 19:57
 */

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        //自定义错误信息
        errorAttributes.put("companyCode","zhognliangrong");
        //获取异常处理中存放的自定义信息
        Object o = webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        errorAttributes.put("ext", o);

        return errorAttributes;
    }
}
