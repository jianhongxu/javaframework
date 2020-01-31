package com.xjh.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @autor xujianhong
 * @date 2020/1/29 14:57
 */
@Service("myUserService")
public class UserService {

    @Autowired
    @Qualifier("userRespsitory")
    private UserDao userDao;


    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("插入完成");
        //int a = 1/0;
    }
}
