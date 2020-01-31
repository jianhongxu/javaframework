package com.xjh.tx;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @autor xujianhong
 * @date 2020/1/29 14:56
 */
@Repository("userRespsitory")
public class UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String  sql = "insert into user(name,addr) values (?,?)";

        jdbcTemplate.update(sql, UUID.randomUUID().toString().substring(0,5),19);

    }
}
