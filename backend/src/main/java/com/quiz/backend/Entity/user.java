package com.quiz.backend.Entity;

import org.springframework.boot.autoconfigure.batch.BatchDataSource;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="userdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String email;
    private String password;
}
