package com.honeybee.developerinterviews.developerinterviews.repositories;

import com.honeybee.developerinterviews.developerinterviews.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
