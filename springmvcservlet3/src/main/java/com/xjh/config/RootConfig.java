package com.xjh.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @autor xujianhong
 * @date 2020/1/31 23:45
 *
 * 根容器 厢遇spring容器
 */

@ComponentScan(basePackages = "com.xjh", excludeFilters =
        {@ComponentScan.Filter(type=FilterType.ANNOTATION, classes = Controller.class)})
public class RootConfig {
}
