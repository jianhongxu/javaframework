package com.xjh.myspringboot.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @autor xujianhong
 * @date 2020/2/6 3:47
 */
public interface BookESRepository extends ElasticsearchRepository<Book, Long> {

    List<Book> findBookByBookName(String bookName);
}
