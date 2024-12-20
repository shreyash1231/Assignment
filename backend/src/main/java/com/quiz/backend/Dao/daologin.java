package com.quiz.backend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.backend.Entity.user;

@Repository
public interface daologin extends JpaRepository<user,Long> {

    @Query(value="select * from userdata where email=:ema and password=:pass",nativeQuery = true)
    user login(@Param("ema")String email,@Param("pass")String password);
    
}
