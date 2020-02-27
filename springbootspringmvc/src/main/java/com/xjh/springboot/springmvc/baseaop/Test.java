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

        //// 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");





        CalculatorInterfaceImpl calculatorInterface = new CalculatorInterfaceImpl();
        //创建代理对象
        JDKDynamicProxy calculatorProxy = new JDKDynamicProxy(calculatorInterface);

        CalculatorInterface proxyObject = (CalculatorInterface)calculatorProxy.getProxy();

        proxyObject.add(1,2);
        proxyObject.desc(5,3);

        //===========================================================
       /*
       System.out.println("============================");

        UserInterfaceImpl userInterface = new UserInterfaceImpl();
        //创建代理对象
        calculatorProxy = new JDKDynamicProxy(userInterface);

        //只能用接口的方式来接这个参数
        UserInterface userInterfaceProxy = (UserInterface)calculatorProxy.getProxy();
        userInterfaceProxy.add("徐建红");
        */
    }
}
