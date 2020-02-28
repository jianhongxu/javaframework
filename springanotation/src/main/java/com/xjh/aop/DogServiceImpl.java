package com.xjh.aop;

import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/2/9 0:50
 */
@Component
public class DogServiceImpl implements DogService {
    @Override
    public int test(String name, Integer age) {
        System.out.println("==============");
        return 1;
    }
}
