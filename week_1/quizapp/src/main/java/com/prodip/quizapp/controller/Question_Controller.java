package com.prodip.quizapp.controller;


import com.prodip.quizapp.Question;
import com.prodip.quizapp.service.Question_Service;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class Question_Controller {

    @Autowired
    Question_Service questionservice;

    @GetMapping("allQuestions")
    public ResponseEntity<List <Question>> getallQuestions() {
        return questionservice.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionservice.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionservice.addQuestion(question);

    }
}

