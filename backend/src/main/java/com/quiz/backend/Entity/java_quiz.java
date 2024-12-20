package com.quiz.backend.Entity;


import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="java_quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class java_quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quiz_id;
    private Long quiz_no;
    private String question;
    private String A;
    private String B;
    private String C;
    private String D;
    private String answer;

}
