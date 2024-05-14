package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.exceptions.ResourceNotFoundException;
import com.honeybee.developerinterviews.developerinterviews.repositories.CategoryRepository;
import com.honeybee.developerinterviews.developerinterviews.repositories.TopicRepository;
import com.honeybee.developerinterviews.developerinterviews.dto.TopicDTO;
import com.honeybee.developerinterviews.developerinterviews.entities.Category;
import com.honeybee.developerinterviews.developerinterviews.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;
    @Override
    public Page<Topic> getAllTopics(Long categoryId, Pageable page) {
        return topicRepository.findByCategoryId(categoryId, page);
    }

    @Override
    public Topic addTopic(Long categoryId, @RequestBody Topic topic) {
        topic.setCategory(categoryService.getCategoryById(categoryId));
        return topicRepository.save(topic);
    }

    @Override
    public Topic getTopicById(Long categoryId, Long id) {
        Optional<Topic> topic = topicRepository.findByCategoryIdAndId(categoryId, id);

        if (topic.isPresent()) {
            return topic.get();
        }

        throw new ResourceNotFoundException(("Topic is not found for the id: " + id + ", within category id: " + categoryId));
    }

    @Override
    public void deleteTopicById(Long categoryId, Long topicId) {
        Topic topic = getTopicById(categoryId, topicId);
        topicRepository.delete(topic);
    }

    @Override
    public Topic updateTopicById(Long categoryId, Long id, Topic topic) {
        Optional<Topic> existingTopic = topicRepository.findByCategoryIdAndId(categoryId, id);

        Topic oldTopic = null;

        if(existingTopic.isPresent()) {
            oldTopic = existingTopic.get();
        } else {
            return oldTopic;
        }

        oldTopic.setTopic_name(topic.getTopic_name() != null ? topic.getTopic_name() : oldTopic.getTopic_name());
        oldTopic.setTopic_name(topic.getTopic_description() != null ? topic.getTopic_description() : oldTopic.getTopic_description());

        return topicRepository.save(oldTopic);
    }
}
