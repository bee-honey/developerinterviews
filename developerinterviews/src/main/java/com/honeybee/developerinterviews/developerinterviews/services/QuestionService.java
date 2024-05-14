package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.entities.Question;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public interface QuestionService {
    Page<Question> findAllQuestionsByTopicId(Long categoryId, Long topicId, Pageable page);
    Question addQuestion(Long categoryId, Long topicId, Question question);

    Question getQuestionById(Long topicId, Long id);

    void deleteQuestionById(Long topicId, Long questionId);

    Question updateQuestionById(Long topicId, Long id, Question question);
}
