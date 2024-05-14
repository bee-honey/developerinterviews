package com.honeybee.developerinterviews.developerinterviews.repositories;

import com.honeybee.developerinterviews.developerinterviews.entities.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByCategoryId(Long categoryId, Pageable page);

    Optional<Topic> findByCategoryIdAndId(Long categoryId, Long id);
}
