package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.entities.Answer;
import com.honeybee.developerinterviews.developerinterviews.entities.Question;
import com.honeybee.developerinterviews.developerinterviews.entities.QuestionType;
import com.honeybee.developerinterviews.developerinterviews.entities.Topic;
import com.honeybee.developerinterviews.developerinterviews.exceptions.InvalidFormatException;
import com.honeybee.developerinterviews.developerinterviews.exceptions.ResourceNotFoundException;
import com.honeybee.developerinterviews.developerinterviews.repositories.CategoryRepository;
import com.honeybee.developerinterviews.developerinterviews.repositories.QuestionRepository;
import com.honeybee.developerinterviews.developerinterviews.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Optional;


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
        Optional<Question> question = questionRepository.findByTopicIdAndId(topicId, id);

        if (question.isPresent() && topicService.getTopicById(categoryId, topicId) != null) {
            return question.get();
        }

        throw new ResourceNotFoundException(("Question is not found for the id: " + id + ", within topic id: " + topicId + " and for category id: " + categoryId));
    }

    @Override
    public void deleteQuestionById(Long categoryId, Long topicId, Long id) {
        Optional<Question> question = questionRepository.findByTopicIdAndId(topicId, id);

        if (question.isPresent() && topicService.getTopicById(categoryId, topicId) != null) {
            questionRepository.delete(question.get());
        }
    }

    @Override
    public Question updateQuestionById(Long categoryId, Long topicId, Long id, Question question) {
        Optional<Question> existingQuestion = questionRepository.findByTopicIdAndId(topicId, id);

        Question oldQuestion = null;

        if (existingQuestion.isPresent()) {
            oldQuestion = existingQuestion.get();
        } else {
            return oldQuestion;
        }

        oldQuestion.setQuestionText(question.getQuestionText() != null ? question.getQuestionText() : oldQuestion.getQuestionText());
        oldQuestion.setQuestionType(question.getQuestionType() != null ? question.getQuestionType() : oldQuestion.getQuestionType());

        return questionRepository.save(oldQuestion);
    }
}
