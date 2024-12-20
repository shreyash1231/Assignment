package com.quiz.backend.Service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class quiz {
    private String question;
    private String A;
    private String B;
    private String C;
    private String D;
}
