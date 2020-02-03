package com.xjh.myspringboot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @autor xujianhong
 * @date 2020/2/1 22:06
 *
 * 属性值自动会绑定yml中的属性
 */
@Data
@ToString
@ConfigurationProperties(prefix = "person")
@Component
//通过注解PropertySource可以引用外部的资源文件
@PropertySource(value={"classpath:/person.properties"})
public class Person {

    private String lastName;
    private Integer age;
    private  Boolean boss;
    private Date brithday;
    private Map<String, Object> maps;

    @Value("${value}")
    private String value;

    @Value("#{2*123}")
    private Integer valueTwo;


    private Dog dog;

}
