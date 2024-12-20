package com.quiz.backend.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.backend.Entity.score;

import jakarta.transaction.Transactional;

@Repository
public interface score_dao extends JpaRepository<score,Long> {

    @Query(value="select * from score where userid=:no",nativeQuery = true)
    List<score> findscore(@Param("no")Long no);
 

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO score (userid, correct, incorrect,totalquestion) VALUES (:userid, :correct, :incorrect,:totaque)", nativeQuery = true)
    void saveScore(
        @Param("userid") Long userid,
        @Param("correct") Long correct,
        @Param("incorrect") Long incorrect,
        @Param("totaque")Long totalquestion
    );

    @Transactional
    @Modifying
    @Query(value = "UPDATE score SET correct = correct + :right, incorrect = incorrect +:wrong,totalquestion=totalquestion+:totaque WHERE userid = :no", nativeQuery = true)
    void update(@Param("right") long right, @Param("wrong") long wrong, @Param("no") Long no,@Param("totaque")Long totalquestion);    

    @Transactional
    @Modifying
    @Query(value="delete from score where userid=:no",nativeQuery = true)
    void deletebyid(@Param("no")Long no);
    

}
