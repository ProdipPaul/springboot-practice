package com.prodip.quizapp.controller;


import com.prodip.quizapp.Question;
import com.prodip.quizapp.service.Question_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class Question_Controller {

    @Autowired
    Question_Service questionservice;

    @GetMapping("allQuestions")
    public List<Question> getallQuestions(){
        return questionservice.getAllQuestions();
    }

    git commit -m "Your descriptive commit message"


}

