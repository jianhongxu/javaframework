package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @autor xujianhong
 * @date 2020/2/4 9:04
 */

@Data
public class ProductMy implements Serializable {
    private static final long serialVersionUID = 1435515995276255188L;
    private long id;
    private String name;
    private Long price;
}
