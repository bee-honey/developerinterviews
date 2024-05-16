package com.honeybee.developerinterviews.developerinterviews.controllers;

import com.honeybee.developerinterviews.developerinterviews.entities.Topic;
import com.honeybee.developerinterviews.developerinterviews.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/categories/{categoryId}/topics")
    public List<Topic> getAllTopics(@PathVariable(value = "categoryId") Long categoryId, Pageable page) {
        return topicService.getAllTopics(categoryId, page).toList();
    }

    @PostMapping("/categories/{categoryId}/topics")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Topic addExpesnse(@PathVariable(value = "categoryId") Long categoryId, @Valid @RequestBody Topic topic) {
        return topicService.addTopic(categoryId, topic);
    }

    @GetMapping("/categories/{categoryId}/topics/{id}")
    public Topic getTopicById(@PathVariable(value = "categoryId") Long categoryId, @PathVariable("id") Long id) {
        return topicService.getTopicById(categoryId, id);
    }
    @DeleteMapping("/categories/{categoryId}/topics")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTopicById(@PathVariable(value = "categoryId") Long categoryId, @RequestParam Long id) {
        topicService.deleteTopicById(categoryId, id);
    }

    @PutMapping("/categories/{categoryId}/topics/{id}")
    public Topic updateTopicById(@PathVariable(value = "categoryId") Long categoryId, @PathVariable("id") Long id, @RequestBody Topic topic) {
        return topicService.updateTopicById(categoryId, id, topic);
    }

}
