package com.prodip.quizapp.service;
import com.prodip.quizapp.Question;
import com.prodip.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Question_Service {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();

    }

}
