package com.xjh.myspringboot.exceptionhander;

/**
 * @autor xujianhong
 * @date 2020/2/3 19:29
 */
public class MyExcepiton extends RuntimeException {

    public MyExcepiton() {
        super("我自己定义的异常......");
    }
}
