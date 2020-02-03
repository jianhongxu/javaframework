package com.xjh.myspringboot;

import com.xjh.myspringboot.domain.Person;
import com.xjh.myspringboot.enetity.Dept;
import com.xjh.myspringboot.enetity.Emply;
import com.xjh.myspringboot.mapper.DeptMapper;
import com.xjh.myspringboot.mapper.EmplyMapper;
import com.xjh.myspringboot.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
public class JPATest {

    @Autowired
    private PersonRepository personRepository;



    @Test
    public void test01() throws Exception{
        System.out.println("jpa接口实现是： "+personRepository);

        Person person = new Person("xujianhong","363722188@qq.com",  new Date());
        System.out.println("保存数据 "+personRepository.save(person));

        System.out.println("查询出的数据是:  "+personRepository.findById(person.getId()));
    }


}
