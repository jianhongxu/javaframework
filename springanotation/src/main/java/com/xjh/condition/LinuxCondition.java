package com.xjh.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @autor xujianhong
 * @date 2020/1/27 19:30
 */
public class LinuxCondition implements Condition {


    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //4、可以获取spring的执行环境信息
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        return osName.contains("linux");
    }
}
