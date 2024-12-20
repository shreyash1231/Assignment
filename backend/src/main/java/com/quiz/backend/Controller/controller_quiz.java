package com.quiz.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.quiz.backend.Entity.java_quiz;
import com.quiz.backend.Entity.score;
import com.quiz.backend.Entity.user;
import com.quiz.backend.Service.quiz;
import com.quiz.backend.Service.ser;

import jakarta.servlet.http.HttpSession;

@RestController
public class controller_quiz {
    
    @Autowired
    private ser servi;
     private void checkAuthentication(HttpSession session) {
        if (session.getAttribute("user") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated.");
        }
    }


    @PostMapping("/signup")
    public String signup(@RequestBody user log) {
        if(log.getEmail()==null||log.getPassword()==null)
        {
            return "fill the details";
        }
        else
        {
            servi.signup(log);
            return "Data Saved Successfully";
        }
    }
    
    @PostMapping("/login")
    public String login(@RequestBody user log,HttpSession session)
    {
        if(log.getEmail()==null||log.getPassword()==null)
        {
            return "fill the details";
        }
        else
        {
            user logi = servi.login(log);
            if(logi==null)
            {
                return "User not register";
            }
            else
            {
                session.setAttribute("user", logi.getUserid());
            }
        }
        return "Login Successfully";
    }
   /* @PostMapping("/questions")
    public String questions(@RequestBody java_quiz java_qui)
    {
        servi.questions(java_qui);
        return "question stored";
    }*/
    @GetMapping("/startquiz")
    public quiz startquiz(HttpSession session)
    {
        if(session.getAttribute("user")==null)
        {
            checkAuthentication(session);
        }
        Long no = (Long)session.getAttribute("user");
        return servi.startquiz(no);
    }
    @GetMapping("/quizanswer/{option}")
    public String quizanswer (@PathVariable("option")String option,HttpSession session)
    {
        if(session.getAttribute("user")==null)
        {
            checkAuthentication(session);
        }
        if(option==null)
        {
            return "Choose the option";
        }
        Long no = (Long)session.getAttribute("user");
        servi.quizanswer(option,no);
        return "Hit the startquiz url again to get next question";
    }
    @GetMapping("/Submit")
    public score submit(HttpSession session)
    {
        if(session.getAttribute("user")==null)
        {
            checkAuthentication(session);
        }
        Long no = (Long)session.getAttribute("user");
        score sc = servi.submit(no);
        if (sc==null) {
            throw new RuntimeException("No scores found for user ID: ");
        }
        return sc;
    }
}
