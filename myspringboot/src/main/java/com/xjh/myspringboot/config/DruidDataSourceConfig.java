package com.xjh.myspringboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor xujianhong
 * @date 2020/2/3 22:14
 *
 * Druid数据源的配置
 */

@Configuration
public class DruidDataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 注入druid数据源的监控servlet StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new StatViewServlet());
        registrationBean.addUrlMappings("/druid/*");

        Map<String,Object> initMap = new HashMap<>();
        initMap.put("loginUsername","admin");
        initMap.put("loginPassword","123456");
        initMap.put("allow","192.168.2.101");
        initMap.put("deny","127.0.0.1");
        // 是否可以重置数据源，禁用HTML页面上的“Reset All”功能
        initMap.put("resetEnable", "false");

        registrationBean.setInitParameters(initMap);
        return registrationBean;
    }

    /**
     * 注册druid的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        //所有请求进行监控处理
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");

        return filterRegistrationBean;
    }
}
