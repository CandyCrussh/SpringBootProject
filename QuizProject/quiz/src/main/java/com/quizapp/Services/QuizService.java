package com.quizapp.Services;

import java.util.List;

import com.quizapp.Entities.QuestionWrapper;
import com.quizapp.Entities.Quiz;
import com.quizapp.Entities.Response;

public interface QuizService {
    
    Quiz createQuiz(String category, int numQ, String title);

    List<QuestionWrapper> getQuizQues(Long id);

    Long calculateResult(Long id, List<Response> responses);
}
