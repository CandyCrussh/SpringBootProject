package com.quizapp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.Entities.Question;
import com.quizapp.Services.QuesService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    private QuesService quesService;

    public QuestionController(QuesService quesService) {
        this.quesService = quesService;
    }

    @SuppressWarnings("null")
    @PostMapping
    public ResponseEntity<Question> create(@RequestBody Question question){
        try{
            return new ResponseEntity<>(quesService.add(question), HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @SuppressWarnings("null")
    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        // return questionService.getAllQuestions();
        try {
            return new ResponseEntity<>(quesService.getAll(), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        
    }

    @SuppressWarnings("null")
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category){
        // return questionService.getAllQuestions();
        try {
            return new ResponseEntity<>(quesService.getAllCategory(category), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getAllQuestionsById(@PathVariable Long id){
        // return questionService.getAllQuestions();
        return new ResponseEntity<>(quesService.getId(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id){
        quesService.delete(id);
        return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllQuestions(){
        quesService.deleteAll();
        return new ResponseEntity<>("All questions deleted successfully", HttpStatus.OK);
    }

}
