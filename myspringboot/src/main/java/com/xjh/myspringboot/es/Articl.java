package com.xjh.myspringboot.es;

import io.searchbox.annotations.JestId;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @autor xujianhong
 * @date 2020/2/6 3:02
 *
 */
@Data
@AllArgsConstructor
public class Articl {

    @JestId
    private Integer id;

    private String author;

    private String title;

    private String content;

    public Articl() {
    }
}
