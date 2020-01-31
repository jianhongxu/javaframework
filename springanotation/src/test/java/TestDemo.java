import com.xjh.aop.CalculatorService;
import com.xjh.config.MainConfig;
import com.xjh.tx.UserService;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:54
 */
public class TestDemo {

    ConfigurableApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void test(){


        //User u = annotationConfigApplicationContext.getBean(User.class);
        //System.out.println(u);

    }

    @Test
    public void test02(){

        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for(String name: names){
            //System.out.println(name);
            if("myFactoryBean".equals(name)){
                System.out.println(annotationConfigApplicationContext.getBean(name).getClass());
                //获取FactoryBean本身
                System.out.println(annotationConfigApplicationContext.getBean("&"+name).getClass());
            }
            if("car".equals(name) || "cat".equals(name) || "dog".equals(name)){
                System.out.println(annotationConfigApplicationContext.getBean(name).getClass());
                //获取FactoryBean本身
               // System.out.println(annotationConfigApplicationContext.getBean("&"+name).getClass());
            }

            if("user".equals(name)){
                System.out.println(annotationConfigApplicationContext.getBean(name));
            }
        }
        annotationConfigApplicationContext.close();
    }

    /**
     *spring aop测试
     */
    @Test
    public void test03(){
        CalculatorService u = annotationConfigApplicationContext.getBean(CalculatorService.class);
        u.div(4,2);
       // u.div(4,0);
    }

    /**
     * 测试事务
     */
    @Test
    public void test04(){
        UserService u = (UserService)annotationConfigApplicationContext.getBean("myUserService");
        u.insertUser();
    }


}
