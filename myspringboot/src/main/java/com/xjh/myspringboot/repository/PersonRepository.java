package com.xjh.myspringboot.repository;

import com.xjh.myspringboot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @autor xujianhong
 * @date 2020/2/4 7:25
 *
 * jpa的dao
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
