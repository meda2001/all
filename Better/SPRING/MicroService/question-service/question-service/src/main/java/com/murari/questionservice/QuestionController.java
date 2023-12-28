package com.murari.questionservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("")
    public List<?> getAllQuestions(){





        return questionService.getAllQuestions();
    }

    @PostMapping("")
    public QuestionEntity postQuestion(@RequestBody QuestionEntity questionEntity){
        return questionService.postQuestion(questionEntity);

    }
}
