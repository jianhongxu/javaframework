package com.example.springbootcode.initializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/14 15:17
 * @Description:
 */

@HandlesTypes({IWebParameter.class})
public class WebConfig implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        Iterator var4;
        if (set!=null){
            var4=set.iterator();
            while(var4.hasNext()){
                Class<?> clazz= (Class<?>) var4.next();
                if (!clazz.isInterface()&& !Modifier.isAbstract(clazz.getModifiers())&& IWebParameter.class.isAssignableFrom(clazz)){
                    try {
                        ((IWebParameter) clazz.newInstance()).loadOnstarp(servletContext);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
