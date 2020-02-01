package com.xjh.springboot.springmvc.baseaop;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:02
 */
public class Test {

    /**
     * jdk自带的动态代理 要被代理的对象必须实现接口
     * @param args
     */
    public static void main(String[] args) {
        CalculatorInterface calculatorInterface = new CalculatorInterfaceImpl();

        CalculatorProxy calculatorProxy = new CalculatorProxy(calculatorInterface);

        CalculatorInterface proxyObject = calculatorProxy.getProxyIntance();

        proxyObject.add(1,2);
        proxyObject.desc(5,3);


    }
}
