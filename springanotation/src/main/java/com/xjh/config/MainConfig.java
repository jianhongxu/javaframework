package com.xjh.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xjh.condition.LinuxCondition;
import com.xjh.condition.WindowsCondition;
import com.xjh.dto.Car;
import com.xjh.dto.Color;
import com.xjh.dto.Red;
import com.xjh.dto.User;
import com.xjh.mybatisspring.MyMapperScan;
import com.xjh.mybatisspring.MybatisImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:51
 */

@Configuration
@ComponentScan("com.xjh")
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class, MybatisImportBeanDefinitionRegistrar.class})
//加载外部的配置文件  一遍可以使用${name}的方式取值
@PropertySource({"classpath:user.properties"})
//开启基于注解的aop功能
@EnableAspectJAutoProxy
//开启事务功能
@EnableTransactionManagement
//探讨mybat-spring中间件的原理
@MyMapperScan
public class MainConfig {

    /**
     *    *@see ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype:原型
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON   singleton：单例
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request作用域
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  session作用域
     * @return
     *
     * 懒加载： 单实例默认是在容器启动的时候创建对象  懒加载就是容器启动后再是实例化对象 @Lazy
     *
     *
     * 往iod容器中加入bean有三种方式
     * 1 @bean
     * 2 @ComponetSan + @Component
     * 3 @Import的方式导入  默认id是全类名
     * 4 @ImportSelector
     * 5  ImportBeanDefinitionRegister 手工注册的方式
     * 6 使用FactoryBean的方式
     * 7 还可以通过BeanFactoryPostProcessor的方式
     *
     *
     * bean的生命周期  初始化和销
     * 1、@Bean注解中可以指定initMethod 和destoryMethod  单实例bean是容器销毁是的时候销毁  多实例bean是你自己手动销毁
     * 2、  通过InitializingBean接口和DisposableBean 实现init和destory方法
     * 3、@PostConstruct 相当于init方法  @PreDestroy相当于 destory
     *
     * 4、 BeanPostProcessor中 postProcessBeforeInitialization是init方法前
     *     postProcessAfterInitialization是init方法后
     *
     *      spring底层很多地方都用了BeanPostProcessor
     *      bean的赋值、注入其他主键、 @Autoware、bean生命周期注解功能、 @Async注解等等
     *
     ****************************spring中bean的生命周期********************************
     * spring中bean的生命周期：
     * 1构造方法  2 属性设置方法 3 postProcessBeforeInitlization 4 init方法 5postProcessAfterInitilization 6 destory方法     注意：3和5是在BeanPostProcessor 接口中定义的方法
     *
     *
     *  ID
     * @Autowared（spring框架的） : 首先按照类型装配， 如果有多个同样的类型  则再按照名称装配 ； 默认是必须要被注入的，如果没有就会报错 或者 讲requried属性设置成false
     * @Qualifier 可以指定特定的bean的名称
     * @Primary当有多个一样的类型的bean的时候 首选是有这个注解标注的bena  使用了@Primary后也可以使用@Qualifier继续指定
     *
     * @Resource（JDK的） 是jdk规范里的 默认是按属性名称装备(不支持@Primary 和 requried属性)
     *
     *
     *
     *
     *
     * 如果自定义的bean要使用spring底层的一些组建， 可以使用实现XXXAware接口 自动回注入进来 例如：BeanFactoryAware 和 ApplicationContextAware等等
     * XXXAwareProcessor都会实现BeanPostProcessor接口 处理XXXAware的功能。 后置处理器的逻辑。
     *
     *
     *
     *
     *
     * @Profile（可以加载方法上的@Bean后面和 类上面） 指定组建在哪种环境中才被激活  默认是default环境  比如还有dev test prod环境
     * 如何使用： 1 使用命令行参数 -Dspring.profiles.active=dev
     *          2 使用代码的方式  ConfigurableApplicationContext.getEnvironment().setActiveProfiles("dev","test"); 可以设置多个
     *            没有标注@profile注解的bean默认是任何环境都会加载
     *
     *
     *
     * AOP
     * 前置通知@Before
     * 后置通知@After
     * 返回通知@AfterReturning
     * 异常通知@AfterThrowing
     * 环绕通知@Around
     *
     * 在spring中有很多 @EnableXXX 表示开启某些功能更
     * JoinPoint joinPoint参数必须出现在方法的第一个参数
     *
     *
     * AnnotationAwareAspectJAutoProxyCreator
     *   SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
     *
     *   aop原理：（1：创建代理对象  2 调用方法的时候是通过代理对象调用目标方法） 拦截器链  拦截器调用拦截器  两条路线  前置通知-》目标方法-》后置通知-》返回通知
     *                                                                                               前置通知-》目标方法-》后置通知-》异常通知
     */

    @Bean("user")
    //bean的作用域
    @Scope()
    //懒加载
    @Lazy
    public User user(){
        return new User("liwaang",67);
    }


    @Bean("windows")
    @Conditional(WindowsCondition.class)
    public User user01(){
        return new User("windows",67);
    }

    @Bean("linux")
    @Conditional(LinuxCondition.class)
    public User user02(){
        return new User("linux",67);
    }

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }


    @Bean(initMethod = "init", destroyMethod ="destory" )
    //@Profile("test")
    public Car car(){
        return new Car();
    }


    /**
     * 往容器中添加数据源
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/kettle");
        return dataSource;
    }

    /**
     * 添加事务管理器
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }
}
