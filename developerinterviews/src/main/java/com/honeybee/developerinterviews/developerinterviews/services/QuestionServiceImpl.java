package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.entities.Answer;
import com.honeybee.developerinterviews.developerinterviews.entities.Question;
import com.honeybee.developerinterviews.developerinterviews.repositories.CategoryRepository;
import com.honeybee.developerinterviews.developerinterviews.repositories.QuestionRepository;
import com.honeybee.developerinterviews.developerinterviews.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    TopicService topicService;

    public Page<Question> findAllQuestionsByTopicId(Long categoryId, Long topicId, Pageable page) {
        return questionRepository.findByTopicId(topicId, page);
    }

    public Question addQuestion(Long categoryId, Long topicId, Question question) {
        // Assume you set the topic on the question after validation
        question.setTopic(topicService.getTopicById(categoryId, topicId));
        if (question.getAnswers() != null) {
            for (Answer answer : question.getAnswers()) {
                answer.setQuestion(question); // Link the answer to the question
            }
        }

        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById(Long categoryId, Long topicId, Long id) {
        return null;
    }

    @Override
    public void deleteQuestionById(Long categoryId, Long topicId, Long questionId) {

    }

    @Override
    public Question updateQuestionById(Long categoryId, Long topicId, Long id, Question question) {
        return null;
    }
}
