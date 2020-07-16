package com.example.springbootcode.test;

import java.util.stream.IntStream;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/16 15:23
 * @Description:外行人都能看得懂的WebFlux，错过了血亏！
 * https://zhuanlan.zhihu.com/p/92460075
 *
 * 响应式编程（reactive programming）是一种基于数据流（data stream）和变化传递（propagation of change）的声明式（declarative）的编程范式；
 *
 * 下面的例子已经可以帮助我们理解变化传递（propagation of change）
 * 在命令式编程(我们的日常编程模式)下，式子a=b+c，这就意味着a的值是由b和c计算出来的。如果b或者c后续有变化，不会影响到a的值
 * 在响应式编程下，式子a:=b+c，这就意味着a的值是由b和c计算出来的。但如果b或者c的值后续有变化，会影响到a的值
 *
 * 那数据流（data stream）和声明式（declarative）怎么理解呢？那可以提一提我们的Stream流了。之前写过Lambda表达式和Stream流的文章，大家可以先去看看：
 *
 * 说了这么多，怎么理解数据流和声明式呢？其实是这样的：
 * 本来数据是我们自行处理的，后来我们把要处理的数据抽象出来（变成了数据流），然后通过API去处理数据流中的数据（是声明式的）
 * 比如下面的代码；将数组中的数据变成数据流，通过显式声明调用.sum()来处理数据流中的数据，得到最终的结果：
 *
 * public static void main(String[] args) {
 *     int[] nums = { 1, 2, 3 };
 *     int sum2 = IntStream.of(nums).parallel().sum();
 *     System.out.println("结果为：" + sum2);
 * }
 *
 * 响应式编程->异步非阻塞
 *
 *
 *
 *
 * 展望响应式编程的场景应用：
 * 比如一个日志监控系统，我们的前端页面将不再需要通过“命令式”的轮询的方式不断向服务器请求数据然后进行更新，而是在建立好通道之后，数据流从系统源源不断流向页面，从而展现实时的指标变化曲线；
 * 再比如一个社交平台，朋友的动态、点赞和留言不是手动刷出来的，而是当后台数据变化的时候自动体现到界面上的。
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 ,4 ,89};
        int sum2 = IntStream.of(nums).parallel().sum();
        System.out.println("结果为：" + sum2);
    }
}
