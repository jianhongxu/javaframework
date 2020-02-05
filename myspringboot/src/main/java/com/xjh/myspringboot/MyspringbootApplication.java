package com.xjh.myspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
/**
 * spring boot 学习模块
 *
 * 1/hello word
 * 2/yaml简介
 * 3/pringboot配置文件 .properties @ConfigurationProperties 和@Value区别 以及spel表达式
 * 4/ 可以通过@PropertySource(value={"classpath:/person.properties"})指定资源文件陆军  可
 *     以通过 @ImportResource(locations = )指定外部的xml配置文件
 * 5/ spring配置文件中的占位符 ${}
 * 6 d多环境profile的支持 以及配置外部配置文件的位置以及默认springboot加载配置文件的方式
 * 7 自动配置原理和自动加载自动配置类的报告 debug= true
 * 8 spring日志相关 日志接口slf4j -实现logback/log4j/log4j2
 *    spring框架默认使用的是JCL(commons-log)
 *    springboot 使用的是slf4j和logback
 *
 *     将系统中原来的框架日志包排除，再用中间包替换
 *     <exclusions>
 *         <exclusion>
 *           <artifactId>commons-logging</artifactId>
 *           <groupId>commons-logging</groupId>
 *         </exclusion>
 *       </exclusions>
 *
 * 日志级别默认由低到高trace<debug<info<warn<error   #spring boot默认的日志级别是info级别的日志
 * logbck-spring.xml里可以配置日志的环境(不同的环境使用不同的日志输出)
 *
 * 替换springboot默认的日志框架 比如可以换成log4j2
 *
 * 9sprinboot对静态资源的映射规则： webMvcAutoConfiguration.java
 * if (!this.resourceProperties.isAddMappings()) {
 * 				logger.debug("Default resource handling disabled");
 * 				return;
 *                        }
 * 			Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
 * 			CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
 * 			if (!registry.hasMappingForPattern("/webjars/**")) {
 * 				customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
 * 						.addResourceLocations("classpath:/META-INF/resources/webjars/")
 * 						.setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
 *            }
 * 			String staticPathPattern = this.mvcProperties.getStaticPathPattern();
 * 			if (!registry.hasMappingForPattern(staticPathPattern)) {
 * 				customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
 * 						.addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
 * 						.setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
 *            }
 *
 *
 *  可以使用webjars的方式引入静态资源：
 * 可以通过ResourceProperties的方式设置静态资源的缓存配置等等spring.resources.chain.enabled=true
 * 如果jar里没有 则默认去classpath:/META-INF/resources/",
 * 	"classpath:/resources/", "classpath:/static/", "classpath:/public/   /:当前项目的跟路径   这几个路径下去找静态资源
 *
 *  欢迎是静态资源文件夹下的index.html页面
 *  网站图标fa
 *
 *
 *  模板开发  ctrl—+F9刷新
 *  springboot结合模板开发例子crud
 *
 *  国际话的开发：（以前）
 *  1、写国际化配置文件
 *  2、使用ResourceBundleMessageSource管理国际化资源文件
 *  3、页面使用fmt:message取出国际化内容
 *
 * （spring boot）只需要编写资源文件
 *   通过MessageSourceAutoConfiguration 已经配置好了
 *
 *   Local和LocalResolver
 *
 *
 * 10 spring boot 默认的错误处理机制(浏览器返回html  其他客服端有返回的json数据)
 *    ErrorMvcAutoConfiguration处理默认的
 *
 *
 */



/**
 *  @SpringBootApplication 一共包含如下三个注解
 * @SpringBootConfiguration  == @Configuratrion  表示是一个配置类  就是一个配置文件
 * @EnableAutoConfiguration
 *        @AutoConfigurationPackage：将主main所在的类包下的所有类扫描到spring容器中
 *        @Import(AutoConfigurationImportSelector.class)  会导入spring-boot-autoconfigure-2.2.4.RELEASE.jar!\META-INF\spring.factories
 *                        中的org.springframework.boot.autoconfigure.EnableAutoConfiguration标注的类
 *
 * @ComponentScan
 */

/**
 * spring boot可以指定多个profile文件
 *    文件名是 application-{profile}.properties/yml
 *    默认使用的是application.properties
 *
 *    激活profile 1可以在默认的配置文件中激活即可：spring.profiles.active=pro
 *    2 yml中可以定义文档快的方式
 *    3 使用命令行的方式 --spring.profile.active = pro
 *    4 虚拟机方式：-Dspring.profile.active=pro
 *
 *
 * 配置文件的加载位置：
 * -file: ./config
 * -file:./
 * -classpath:/config/
 * -classpath:/
 * 已上按照优先级从高到低
 * 也可以通过命令行参数--spring.config.location类改变默认的位置（在项目已经打包后 在命令行）
 * 高优先级和低优先级会形成互补配置
 *
 *
 *
 *
 *通过规则
 * XXXAutoConfiguration类：springboot启动的时候会自动加载到容器
 * 所有的配置属性 都是 xxxProperties类中 比如：HttpProperties
 *
 * 自动配置类在一定的条件才会生效
 * 可以通过配置文件中配置debug=true 来查看生成自动配置类生效
 *
 *
 *
 */


//可以导入spring的配置xml文件  @ImportResource(locations = )
@SpringBootApplication
@MapperScan("com.xjh.myspringboot.mapper")
//开启缓存功能
@EnableCaching
//开启Rabbit功能
@EnableRabbit
public class MyspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

}
