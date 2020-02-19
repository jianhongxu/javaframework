package com.example.demo;

import com.example.demo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 测试类中加上@ActiveProfiles(profiles = "test")注解来启用test环境下的配置

@ActiveProfiles(profiles = "test")
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test() {
        long productId = 1;
        Product product = restTemplate.getForObject("http://localhost:" + port + "/product/" + productId, Product.class);
        assertThat(product.getPrice()).isEqualTo(200);
        Product newProduct = new Product();
        long newPrice = new Random().nextLong();
        newProduct.setName("new name");
        newProduct.setPrice(newPrice);
        restTemplate.put("http://localhost:" + port + "/product/" + productId, newProduct);
        Product testProduct = restTemplate.getForObject("http://localhost:" + port + "/product/" + productId, Product.class);
        assertThat(testProduct.getPrice()).isEqualTo(newPrice);
    }


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"skjdf");
    }

}
