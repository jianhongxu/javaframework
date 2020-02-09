package com.xjh.mybatisspring;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @autor xujianhong
 * @date 2020/2/9 22:11
 */
public interface DogDao {

    @Select("select * from dog")
    List<Map<String, Object>> query();
}
