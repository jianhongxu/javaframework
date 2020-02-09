package com.xjh.mybatisspring;

import com.xjh.config.MyImportBeanDefinitionRegister;
import com.xjh.config.MyImportSelector;
import com.xjh.dto.Color;
import com.xjh.dto.Red;
import org.springframework.context.annotation.Import;

/**
 * @autor xujianhong
 * @date 2020/2/9 22:37
 */
@Import({MybatisImportBeanDefinitionRegistrar.class})
public @interface MyMapperScan {
}
