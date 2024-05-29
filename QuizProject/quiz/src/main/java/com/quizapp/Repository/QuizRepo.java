package com.quizapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.Entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long> {
    
}
