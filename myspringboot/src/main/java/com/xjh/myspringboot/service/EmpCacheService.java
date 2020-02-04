package com.xjh.myspringboot.service;

import com.xjh.myspringboot.enetity.CacheEmp;
import com.xjh.myspringboot.mapper.CacheEmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @autor xujianhong
 * @date 2020/2/4 20:48
 */

@CacheConfig(cacheNames = "emp")
@Service
public class EmpCacheService {

    @Autowired
    private CacheEmpMapper cacheEmpMapper;


    @Cacheable(/*cacheNames = "emp"*/)
    public CacheEmp queryEmpById(Long id){
        return cacheEmpMapper.selectByPrimaryKey(id);
    }


    @CachePut(/*cacheNames = "emp", */key = "#result.id")
    public CacheEmp udpateEmpById(CacheEmp cacheEmp){
        cacheEmpMapper.updateByPrimaryKeySelective(cacheEmp);
        return cacheEmp;
    }


    @CacheEvict(/*cacheNames = "emp",*/ key = "#id")
    public void deleteEmpById(Long id){
        //cacheEmpMapper.deleteByPrimaryKey(id);
    }



    @Caching(cacheable = {@Cacheable(/*cacheNames = "emp",*/ key="#name")},put = {
            @CachePut(/*cacheNames = "emp",*/ key="#result.address"),
            @CachePut(/*cacheNames = "emp",*/ key="#result.age"),
            @CachePut(/*cacheNames = "emp",*/ key="#result.id")
    })
    public CacheEmp queryEmpByKeyword(String name){
        return cacheEmpMapper.queryEmpByKeyword(name);
    }
}
