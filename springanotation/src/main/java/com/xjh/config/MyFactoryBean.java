package com.xjh.config;

import com.xjh.dto.Green;
import org.springframework.beans.factory.FactoryBean;

/**
 * @autor xujianhong
 * @date 2020/1/27 20:07
 */
public class MyFactoryBean implements FactoryBean<Green> {


    public Green getObject() {
        return new Green();
    }

    public Class<Green> getObjectType() {
        return Green.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
