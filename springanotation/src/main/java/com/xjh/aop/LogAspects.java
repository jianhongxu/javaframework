package com.xjh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @autor xujianhong
 * @date 2020/1/28 21:19
 * 这是spring的一个切面
 */
@Component
//告诉spring这个是切面类
@Aspect
public class LogAspects {

    /**
     * 切入点的定义
     * aop表达式
     */
    @Pointcut("execution(public int com.xjh.aop.CalculatorService.*(*,*))")
    public void pointCut(){}


    /**
     * 方法开始
     */
    //指定那个方法来切入
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println("《前置通知》 方法名："+joinPoint.getSignature().getName()+" 参数：{}"+ Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 方法结束
     */
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("《后置通知-finally》After方法运行结束");

    }

    /**
     * 方法返回
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("《返回通知》AfterReturning方法运行返回 返回值：{}"+result);

    }

    /**
     * 方法异常
     */
    @AfterThrowing(value = "pointCut()", throwing="excption")
    public void logExcepiton(Exception excption){
        System.out.println("《异常通知》AfterThrowing 方法运行异常 异常信息：{}"+excption);
    }
}
