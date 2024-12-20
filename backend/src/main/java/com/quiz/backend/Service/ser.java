package com.quiz.backend.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.backend.Dao.daologin;
import com.quiz.backend.Dao.quiz_dao;
import com.quiz.backend.Dao.score_dao;
import com.quiz.backend.Entity.java_quiz;
import com.quiz.backend.Entity.score;
import com.quiz.backend.Entity.user;

import jakarta.servlet.http.HttpSession;

@Service
public class ser {

    @Autowired
    private quiz_dao da;
    @Autowired
    private score_dao sco;
    @Autowired
    private nogenerator nogen;
    @Autowired
    private daologin daolog;
    int option=0;
    int flag=0;
    long count=1;
    List<Long> li = new ArrayList<>();
    public quiz startquiz(Long no) {
        java_quiz java_qui = new java_quiz();
        quiz qui = new quiz();
        Long num = da.count();
        do {
            count = nogen.randomno(num);
        }   while (li.contains(count));
            java_qui = da.startquiz(count);
            qui.setQuestion(java_qui.getQuestion());
            qui.setA(java_qui.getA());
            qui.setB(java_qui.getB());
            qui.setC(java_qui.getC());
            qui.setD(java_qui.getD());
            if(this.flag==1)
            {
                li.add(count);
                count(no);
                this.flag=0;
            }
            return qui;
        }
        public score count(long no){
            score scc= new score();
            if(li.size()-1==da.count())
            {
                scc =submit(no);
            }
            return scc;
        }
    public void quizanswer(String option,Long no) {
        this.flag=1;
        long right=0, wrong =0;
        long totalquestion=0;
        this.option=this.option+1;
        java_quiz java_qui = new java_quiz();
        java_qui=da.startquiz(count);
        if(java_qui.getAnswer().equals(option))
        {
            right=1;
            totalquestion=totalquestion+1;
        }
        else
        {
            wrong =1;
            totalquestion=totalquestion+1;
        }
        if(this.option==1)
        {
            sco.saveScore(no,right,wrong,totalquestion);
        }
        else
        {
            sco.update(right,wrong,no,totalquestion);
        }
    }

    public score submit(Long no) {
        List<score> lis = sco.findscore(no);
        if (lis == null || lis.isEmpty()) {
            throw new RuntimeException("No scores found for user ID: " + no);
        }
        score sc = lis.get(lis.size()-1);
        sco.deletebyid(no);
        li.clear();
        this.option=0;
        this.flag=0;
        return sc;
    }
    
    /*public void questions(java_quiz java_qui) {
       da.save(java_qui);
    }*/

    public void signup(user log) {
        daolog.save(log);
    }

    public user login(user log) {
        String email = log.getEmail();
        String password = log.getPassword();
        return daolog.login(email,password);
    }
}
