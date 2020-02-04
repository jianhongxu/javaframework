package com.xjh.myspringboot;

import com.xjh.myspringboot.domain.Person;
import com.xjh.myspringboot.enetity.CacheEmp;
import com.xjh.myspringboot.repository.PersonRepository;
import com.xjh.myspringboot.service.EmpCacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Date;

/**
 * spring boot缓存测试
 */
@SpringBootTest
public class CacheTest {

    @Autowired
    private EmpCacheService empCacheService;


    /**
     * k ->v都是字符串的形式
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * k -v 都是字符串的形式
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name="myRedisTemplate")
    private RedisTemplate myRedisTemplate;



    @Test
    public void test01() throws Exception{
        System.out.println("查询的一号员工是： "+empCacheService.queryEmpById(1l));
        for (int i = 0; i < 3; i++) {
            System.out.println("再次查询的一号员工是： "+empCacheService.queryEmpById(1l));
        }
        System.out.println("查询的2号员工是： "+empCacheService.queryEmpById(2l));
        for (int i = 0; i < 3; i++) {
            System.out.println("再次查询的2号员工是： "+empCacheService.queryEmpById(2l));
        }

    }

    @Test
    public void test02() throws Exception{
        System.out.println("查询的一号员工是： "+empCacheService.queryEmpById(1l));

        CacheEmp cacheEmp = empCacheService.queryEmpById(1l);

        System.out.println("第二次查询： "+cacheEmp);

        //
        CacheEmp cacheEmp1 = new CacheEmp();
        BeanUtils.copyProperties(cacheEmp, cacheEmp1);
        cacheEmp1.setUserName("徐建红_更新");

        empCacheService.udpateEmpById(cacheEmp1);
        System.out.println("查询的一号员工是： "+empCacheService.queryEmpById(1l));
    }


    /**
     * 测试删除缓存  删除缓存后继续查数据库
     * @throws Exception
     */
    @Test
    public void test03() throws Exception{
        System.out.println("查询的一号员工是： "+empCacheService.queryEmpById(2l));
        CacheEmp cacheEmp = empCacheService.queryEmpById(2l);
        System.out.println("第二次查询： "+cacheEmp);
        empCacheService.deleteEmpById(2l);
        System.out.println("查询的一号员工是： "+empCacheService.queryEmpById(2l));

    }


    @Test
    public void test04() throws Exception{

        CacheEmp cacheEmp = empCacheService.queryEmpByKeyword("员工");
        System.out.println("查询的一号员工是： "+cacheEmp);
        System.out.println("第二次查询： "+empCacheService.queryEmpById(2l));
    }

    @Test
    public void test05() throws Exception{
        stringRedisTemplate.opsForValue().append("mgs","我是redis字符串值");
        CacheEmp cacheEmp = empCacheService.queryEmpByKeyword("员工");
        myRedisTemplate.opsForValue().set("emp2323", cacheEmp);
    }


}
