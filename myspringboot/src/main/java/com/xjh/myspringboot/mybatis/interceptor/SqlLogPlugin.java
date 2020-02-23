package com.xjh.myspringboot.mybatis.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/2/23 11:48
 * @Description: mybatis的一个插件例子
 *
 *
 * 编写好这个类后，
 * 接下来我们需要在mybatis-config.xml配置该拦截器：
 *<plugins>
 *     <plugin interceptor="com.cl.mybatis.learn.intercaptor.SqlLogPlugin">
 *         <property name="参数1" value="root"/>
 *         <property name="参数2" value="123456"/>
 *     </plugin>
 * </plugins>
 *
 *
 */


/**该注解签名告诉此拦截器拦截四大对象中的哪个对象的哪个方法，以及方法的签名信息*/
@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})
})
public class SqlLogPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        long begin = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            long time = System.currentTimeMillis() - begin;
            System.out.println("sql 运行了 ：" + time + " ms");
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
