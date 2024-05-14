package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.repositories.AnswerRepository;
import com.honeybee.developerinterviews.developerinterviews.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    public Answer save(Answer option) {
        return answerRepository.save(option);
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }
}
