package com.xjh.myspringboot.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @autor xujianhong
 * @date 2020/2/4 7:19
 */


@Data
//jpa注解
@Entity
@Table(name="jpa_person")
public class Person implements Serializable {

    //主键自增长
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="last_name", nullable = true, length = 50)
    private String lastName;

    @Column(name="email", nullable = true, length = 50)
    private String email;

    @Column
    private Date brithday;

    public Person() {
    }

    public Person(String lastName, String email, Date brithday) {
        this.lastName = lastName;
        this.email = email;
        this.brithday = brithday;
    }
}
