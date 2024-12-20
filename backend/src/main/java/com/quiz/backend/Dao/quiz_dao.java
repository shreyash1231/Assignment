package com.quiz.backend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.backend.Entity.java_quiz;


@Repository
public interface quiz_dao extends JpaRepository<java_quiz,Long>{
    @Query(value="select * from java_quiz where quiz_no=:count",nativeQuery = true)
    java_quiz startquiz(@Param("count")long count);
    
}
