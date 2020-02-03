package com.xjh.myspringboot;

import com.xjh.myspringboot.bean.Person;
import com.xjh.myspringboot.config.MyLocalesolver;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
class MyspringbootApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext applicationContext;


    @Autowired
    MyLocalesolver myLocalesolver;

    //租入数据源
    @Autowired
    DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        System.out.println(person);
        System.out.println(myLocalesolver);

    }

    @Test
    public void test01(){
        System.out.println(applicationContext.containsBean("userService"));
    }

    /**
     * 测试日志级别
     */
    @Test
    public void test02(){
        /**
         * 日志级别默认由低到高trace<debug<info<warn<error
         */
        logger.trace("这是trace级别的日志");
        logger.debug("这是debug级别的日志");
        logger.info("这是info级别的日志");
        //spring boot默认的日志级别是info级别的日志 可以在配置文件里通过logger.leven属性调整
        logger.warn("这是warn级别的日志");
        logger.error("这是error级别的日志");
    }

    @Test
    public void test03() throws Exception{
        System.out.println("拿到的数据源是:"+dataSource.getClass());
        System.out.println("获取到的连接...."+dataSource.getConnection());

        System.out.println("获取的jdbcTempalte是:"+jdbcTemplate);
    }


}
