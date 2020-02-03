package com.xjh.myspringboot.enetity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import java.io.Serializable;

/**
 * @autor xujianhong
 * @date 2020/2/3 23:31
 */
@Data
@ToString
@AllArgsConstructor
public class Dept implements Serializable {

    private Long id;

    private String deptName;


    public Dept() {
    }

    public Dept(Long id) {
        this.id = id;
    }

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
