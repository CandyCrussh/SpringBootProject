package com.quizapp.Services;

import java.util.List;

import com.quizapp.Entities.Question;

public interface QuesService {
    
    Question add(Question question);

    Question getId(Long id);

    List<Question> getAll();

    List<Question> getAllCategory(String category);

    Question update(Question question);

    void delete(Long id);

    void deleteAll();

}
