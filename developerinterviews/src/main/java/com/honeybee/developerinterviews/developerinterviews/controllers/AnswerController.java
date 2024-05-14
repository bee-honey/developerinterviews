package com.honeybee.developerinterviews.developerinterviews.controllers;

import com.honeybee.developerinterviews.developerinterviews.entities.Answer;
import com.honeybee.developerinterviews.developerinterviews.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public List<Answer> getAllAnswers() {
        return answerService.findAll();
    }

    @PostMapping
    public Answer createAnswer(@RequestBody Answer option) {
        return answerService.save(option);
    }
}
