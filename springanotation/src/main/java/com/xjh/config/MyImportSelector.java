package com.xjh.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @autor xujianhong
 * @date 2020/1/27 19:47
 */

/**
 * 自定以返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param importingClassMetadata  当前所有标注@Import注解的类的所有注解信息
     * @return  返回值就是导入容器中的组件的全类名
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //不能返回null 可以返回空数组
        return new String[]{"com.xjh.dto.Blue"};
    }
}
