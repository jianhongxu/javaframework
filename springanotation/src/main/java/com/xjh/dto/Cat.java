package com.xjh.dto;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/27 20:27
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public void afterPropertiesSet() {
        System.out.println("采用实现接口InitializingBean, DisposableBean的方式 在属性设置完成后执行............Cat ");
    }

    public void destroy() {
        System.out.println("destory............fangshi ");
    }
}
