package com.xjh.myspringboot;

import com.xjh.extimpl.SchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class MyStarterTest {

    @Autowired
    private SchoolService schoolService;


    /**
     * 测试自定的stater
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        System.out.println(schoolService.saySchollHello("徐建"));
    }


}
