package com.prodip.quizapp.controller;


import com.prodip.quizapp.Question;
import com.prodip.quizapp.service.Question_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class Question_Controller {

    @Autowired
    Question_Service questionservice;

    @GetMapping("allQuestions")
    public List<Question> getallQuestions() {
        return questionservice.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionservice.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){

        return questionservice.addQuestion(question);

    }


}

