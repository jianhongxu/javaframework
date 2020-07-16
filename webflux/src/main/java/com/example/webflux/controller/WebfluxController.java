package com.example.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/16 16:19
 * @Description:
 * https://zhuanlan.zhihu.com/p/92460075
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class WebfluxController {

    // 阻塞5秒钟
    private String createStr() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        return "some string";
    }

    // 普通的SpringMVC方法
    @GetMapping("/springmvc")
    private String get1() {
        log.info("get1 start");
        String result = createStr();
        log.info("get1 end.");
        return result;
    }

    // WebFlux(返回的是Mono)
    @GetMapping("/webflux")
    private Mono<String> get2() {
        log.info("get2 start");
        Mono<String> result = Mono.fromSupplier(() -> createStr());
        log.info("get2 end.");
        return result;
    }


    /**
     * 效果就是每秒会给浏览器推送数据：
     * @return
     */
    @GetMapping(value = "/webflux2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<String> flux() {
        Flux<String> result = Flux
                .fromStream(IntStream.range(1, 5).mapToObj(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    return "服务端推送数据：.......flux data--" + i;
                }));
        return result;
    }
}
