package com.honeybee.developerinterviews.developerinterviews.repositories;

import com.honeybee.developerinterviews.developerinterviews.entities.Question;
import com.honeybee.developerinterviews.developerinterviews.entities.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Page<Question> findByTopicId(Long topicId, Pageable page);

    Optional<Question> findByTopicIdAndId(Long topicId, Long id);
}
