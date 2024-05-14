package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Page<Category> getAllCategories(Pageable page);

    Category addCategory(Category category);

    Category getCategoryById(Long id);

    void deleteCategoryById(Long id);

    Category updateCategoryById(Long id, Category expense);
}
