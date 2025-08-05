package com.example.quizapp;

import com.example.quizapp.Service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Quiz")
public class QuizController {
     QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody String category,@RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category,numQ,title);
    }

}
