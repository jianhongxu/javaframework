package com.xjh.aop;

import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/27 17:50
 */

@Component
public class CalculatorService {

    public int div(int a, int b) {
        System.out.println("CalculatorService  div 方法执行");
        return a/b;
    }

}
