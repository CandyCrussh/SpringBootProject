package com.quizapp.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quizapp.Entities.Question;
import com.quizapp.Entities.QuestionWrapper;
import com.quizapp.Entities.Quiz;
import com.quizapp.Entities.Response;
import com.quizapp.Repository.QuestionRepo;
import com.quizapp.Repository.QuizRepo;
import com.quizapp.Services.QuizService;

@Service
public class QuizImpl implements QuizService {
    
    QuizRepo quizRepo;

    QuestionRepo quesRepo;

    public QuizImpl(QuizRepo quizRepo, QuestionRepo questionRepo) {
        this.quizRepo = quizRepo;
        this.quesRepo = questionRepo;
    }
    
    public Quiz createQuiz(String category, int numQ, String title){

        List<Question> ques = quesRepo.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(ques);
        return quizRepo.save(quiz);
    }

    public List<QuestionWrapper> getQuizQues(Long id){
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questionfromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionforUser = new ArrayList<>();
        for(Question q : questionfromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(),q.getOption4());
            questionforUser.add(qw);
        }
        return questionforUser;
    }

    public Long calculateResult(Long id, List<Response> responses){
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response res : responses){
            if(res.getResponse().equals(questions.get(i).getCorrectAnswer())){
                right++;
            }
            i++;
        }
        return (long) right;
    }
}
