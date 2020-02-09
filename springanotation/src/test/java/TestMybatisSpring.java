import com.xjh.config.MainConfig;
import com.xjh.mybatisspring.DogDao;
import com.xjh.mybatisspring.UserTestDao;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:54
 * 测试mybatis-spring中间件的原代理
 */
public class TestMybatisSpring {

    ConfigurableApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);



    @Test
    public void test(){
        UserTestDao userDao = (UserTestDao) annotationConfigApplicationContext.getBean("UserTestDao");
        userDao.query();

        DogDao dogDao = (DogDao) annotationConfigApplicationContext.getBean("DogDao");
        dogDao.query();
    }



}
