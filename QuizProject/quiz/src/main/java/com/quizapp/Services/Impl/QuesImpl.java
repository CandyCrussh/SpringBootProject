package com.quizapp.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quizapp.Entities.Question;
import com.quizapp.Repository.QuestionRepo;
import com.quizapp.Services.QuesService;

@Service
public class QuesImpl implements QuesService{

    private QuestionRepo questionRepo;

    public QuesImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public Question add(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question getId(Long id) {
        return questionRepo.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public List<Question> getAll() {
        return questionRepo.findAll();
    }

    @Override
    public Question update(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public void delete(Long id) {
        questionRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        questionRepo.deleteAll();
    }

    @Override
    public List<Question> getAllCategory(String category) {
        return questionRepo.findByCategory(category);
    }
    
}
