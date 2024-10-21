package com.honeybee.developerinterviews.developerinterviews.controllers;

import com.honeybee.developerinterviews.developerinterviews.entities.Question;
import com.honeybee.developerinterviews.developerinterviews.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/categories/{categoryId}/topics/{topicId}/questions")
    public List<Question> getAllQuestionsByTopic(
            @PathVariable(value = "categoryId") Long categoryId,
            @PathVariable(value = "topicId") Long topicId, Pageable page) {
        return questionService.findAllQuestionsByTopicId(categoryId, topicId, page).toList();
    }

    // POST a new question to a topic
    @PostMapping("/categories/{categoryId}/topics/{topicId}/questions")
    public ResponseEntity<Question> createQuestion(
            @PathVariable(value = "categoryId") Long categoryId,
            @PathVariable(value = "topicId") Long topicId,
            @RequestBody Question question) {
            Question savedQuestion = questionService.addQuestion(categoryId, topicId, question);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestion);
    }

    // Additional methods to handle PUT, DELETE etc. can also be implemented here
    @GetMapping("/categories/{categoryId}/topics/{topicId}/questions/{id}")
    public Question getQuestionById(@PathVariable(value = "categoryId") Long categoryId,
                                         @PathVariable(value = "topicId") Long topicId,
                                         @PathVariable("id") Long id) {
        return questionService.getQuestionById(categoryId, topicId, id);
    }
    @DeleteMapping("/categories/{categoryId}/topics/{topicId}/questions")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteQuestionById(@PathVariable(value = "categoryId") Long categoryId,
                                   @PathVariable(value = "topicId") Long topicId,
                                   @RequestParam Long id) {
        questionService.deleteQuestionById(categoryId, topicId, id);
    }

    @PutMapping("/categories/{categoryId}/topics/{topicId}/questions/{id}")
    public Question updateQuestionById(@PathVariable(value = "categoryId") Long categoryId,
                                       @PathVariable(value = "topicId") Long topicId,
                                       @PathVariable("id") Long id,
                                       @RequestBody Question question) {
        return questionService.updateQuestionById(categoryId, topicId, id, question);
    }
}
