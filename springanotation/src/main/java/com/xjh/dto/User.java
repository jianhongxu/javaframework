package com.xjh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:51
 */
@Data
@AllArgsConstructor
@ToString
public class User {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

}
