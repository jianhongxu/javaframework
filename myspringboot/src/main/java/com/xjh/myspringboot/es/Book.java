package com.xjh.myspringboot.es;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @autor xujianhong
 * @date 2020/2/6 3:48
 */
@Data
@ToString
//es相关注解
@Document(indexName = "xjh",type = "books")
public class Book {

    private Long id;
    private String bookName;
    private String author;
}
