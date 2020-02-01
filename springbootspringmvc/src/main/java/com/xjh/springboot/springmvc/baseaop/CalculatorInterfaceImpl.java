package com.xjh.springboot.springmvc.baseaop;

/**
 * @autor xujianhong
 * @date 2020/1/27 17:50
 */

public class CalculatorInterfaceImpl implements CalculatorInterface {

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int desc(int a, int b) {
        return a-b;
    }
}
