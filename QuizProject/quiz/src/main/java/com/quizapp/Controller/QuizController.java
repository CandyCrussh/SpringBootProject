package com.quizapp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.Entities.QuestionWrapper;
import com.quizapp.Entities.Quiz;
import com.quizapp.Entities.Response;
import com.quizapp.Services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return new ResponseEntity<>(quizService.createQuiz(category, numQ, title), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Long id){
        return new ResponseEntity<>(quizService.getQuizQues(id), HttpStatus.OK);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Long> submitQuiz(@PathVariable Long id, @RequestBody List<Response> responses){
        return new ResponseEntity<>(quizService.calculateResult(id, responses), HttpStatus.OK);
    }
}
