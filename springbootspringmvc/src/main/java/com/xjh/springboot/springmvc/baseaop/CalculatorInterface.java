package com.xjh.springboot.springmvc.baseaop;

/**
 * @autor xujianhong
 * @date 2020/1/27 17:48
 * 计算器接口  使用jdk自带的动态代理添加日志
 */
public interface CalculatorInterface {

    int add(int a, int b);

    int desc(int a, int b);
}
