package com.xjh.myspringboot.asynctask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor xujianhong
 * @date 2020/2/6 19:35
 */

@RestController
public class AsyncTaskController {

    @Autowired
    AsyncTaskServiec asyncTaskServiec;

    @RequestMapping("/asynctask")
    public Object testAsyncTask(){
        asyncTaskServiec.handleTask();
        return "success";

    }
}
