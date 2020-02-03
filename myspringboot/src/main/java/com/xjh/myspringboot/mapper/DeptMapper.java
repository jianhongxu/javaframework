package com.xjh.myspringboot.mapper;

import com.xjh.myspringboot.enetity.Dept;
import org.apache.ibatis.annotations.*;

/**
 * @autor xujianhong
 * @date 2020/2/3 23:32
 */


public interface DeptMapper {

    @Select("select * from Dept where id = #{id}")
    Dept queryDeptById(Long id);

    @Insert("insert dept(dept_name) values(#{deptName})")
    int insertDept(Dept dept);

    @Update("update dept set dept_name = #{deptName} where id = #{id}")
    int updateDept(Dept dept);

    @Delete("delete from dept where id = #{id}")
    int deleteDept(Long id);

}
