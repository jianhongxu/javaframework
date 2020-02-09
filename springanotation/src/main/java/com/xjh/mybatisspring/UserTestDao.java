package com.xjh.mybatisspring;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @autor xujianhong
 * @date 2020/2/9 21:48
 */
public interface UserTestDao {

    @Select("select * from user")
    List<Map<String, Object>> query();
}
