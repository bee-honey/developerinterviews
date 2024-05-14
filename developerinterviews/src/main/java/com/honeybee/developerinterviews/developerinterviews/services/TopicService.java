package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.entities.Topic;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public interface TopicService {
    Page<Topic> getAllTopics(Long categoryId, Pageable page);

    Topic addTopic(Long categoryId, Topic topic);

    Topic getTopicById(Long categoryId, Long id);

    void deleteTopicById(Long categoryId, Long topicId);

    Topic updateTopicById(Long categoryId, Long id, Topic topic);
}
