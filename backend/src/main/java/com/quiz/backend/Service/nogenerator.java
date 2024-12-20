package com.quiz.backend.Service;

import org.springframework.stereotype.Service;

@Service
public class nogenerator {
    private static final long min=1; 
    private Long max; 
    public Long randomno(Long num)
    {
        this.max=num;
        long b = (long)(Math.random()*(max-min+1)+min);  
        return b;
    }
}  
