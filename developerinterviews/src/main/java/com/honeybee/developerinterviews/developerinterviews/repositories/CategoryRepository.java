package com.honeybee.developerinterviews.developerinterviews.repositories;

import com.honeybee.developerinterviews.developerinterviews.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
