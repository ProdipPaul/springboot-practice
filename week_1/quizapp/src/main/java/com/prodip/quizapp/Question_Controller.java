package com.prodip.quizapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class Question_Controller {

    @GetMapping("allQuestions")
    public String getallQuestions(){
        return "Hi... These are your Questions";
    }


}

