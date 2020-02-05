package com.xjh.myspringboot;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xjh.myspringboot.enetity.CacheEmp;
import com.xjh.myspringboot.es.Articl;
import com.xjh.myspringboot.es.Book;
import com.xjh.myspringboot.es.BookESRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.Date;

/**
 * spring boot
 * ES JSET和spring data es测试
 */
@SpringBootTest
public class EsJestTest {

    /**
     * rabbitmq的客户端
     */
    @Autowired
    private JestClient jestClient;

    @Autowired
    private BookESRepository bookESRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Test
    public void test01() throws Exception{
        Articl articl = new Articl(1, "zhangsan", "好消息", "hi, hello word");
        Index index = new Index.Builder(articl).index("xjh").type("news").build();
        jestClient.execute(index);
    }

    @Test
    public void test02() throws Exception{
        String queryJson= "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(queryJson).addIndex("xjh").addType("news").build();
        System.out.println(jestClient.execute(search).getJsonObject());
    }


    @Test
    public void test03() throws Exception{
        Book book = new Book();
        book.setId(1l);
        book.setAuthor("xujianhong");
        book.setBookName("我是一个中国人");
        bookESRepository.save(book);

        for (Book b : bookESRepository.findBookByBookName("中国")){
            System.out.println(b);
        }
        //ES的操作客户端
        System.out.println("ES的操作客户端 elasticsearchTemplate"+elasticsearchTemplate);

    }



}
