package com.quizapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quizapp.Entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Long>{

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category =:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
