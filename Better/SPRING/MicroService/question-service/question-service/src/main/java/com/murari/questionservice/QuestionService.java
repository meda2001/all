package com.murari.questionservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;


    public List<?> getAllQuestions(){



        return questionRepo.findAll();
    }


    public QuestionEntity postQuestion(QuestionEntity questionEntity) {


        QuestionEntity questionJava = new QuestionEntity(1,"what is java?","java is programming language");

        QuestionEntity questionPython = new QuestionEntity(2,"what is python ?" ,"I love python");

        QuestionEntity questionHtml = new QuestionEntity(3,"Do you learn Html ?","yes i learn html too");

        QuestionEntity questionAngular =new QuestionEntity(4,"do you like Angular ?","yes i love Angular");
        QuestionEntity questionSpringBoot = new QuestionEntity(5,"are you working on MicroServices","yes i am learning");


        questionRepo.save(questionAngular);
        questionRepo.save(questionJava);
        questionRepo.save(questionHtml);
        questionRepo.save(questionPython);
        questionRepo.save(questionSpringBoot);
        return questionRepo.save(questionEntity);
    }
}
