package com.xjh.myspringboot;

import com.xjh.myspringboot.enetity.Dept;
import com.xjh.myspringboot.enetity.Emply;
import com.xjh.myspringboot.mapper.DeptMapper;
import com.xjh.myspringboot.mapper.EmplyMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;
import java.util.Date;
import java.util.UUID;

@SpringBootTest
public class DeptAnntationTests {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmplyMapper emplyMapper;




    private Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void test01(){
        System.out.println(deptMapper.queryDeptById(1L));
    }

    /**
     * 测试日志级别
     */
    @Test
    public void test02(){
        Dept dept = new Dept("ccc"+UUID.randomUUID().toString().substring(0,5));
        System.out.println(deptMapper.insertDept(dept));
    }

    @Test
    public void test03() throws Exception{
        Dept dept = new Dept(2l,"UUUUUUUU");
        System.out.println(deptMapper.updateDept(dept));
    }

    @Test
    public void test04() throws Exception{
        System.out.println(deptMapper.deleteDept(4L));
    }

    @Test
    public void test05() throws Exception{
        System.out.println(emplyMapper);

        Emply emply = new Emply("XUJIANHONG",new Date(),32,"重庆是渝中区");
        int result = emplyMapper.insert(emply);
        System.out.println("插入数据："+result);
        System.out.println(emplyMapper.selectByPrimaryKey(emply.getId()));

        emply.setAddress("重庆是渝中区uuuuuuuuuu");
        emplyMapper.updateByPrimaryKeySelective(emply);
        System.out.println("更新后的数据是: "+emplyMapper.selectByPrimaryKey(emply.getId()));


        System.out.println("删除的数据是: "+emplyMapper.deleteByPrimaryKey(emply.getId()));
    }


}
