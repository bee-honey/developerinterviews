package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.repositories.CategoryRepository;
import com.honeybee.developerinterviews.developerinterviews.entities.Category;
import com.honeybee.developerinterviews.developerinterviews.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getAllCategories(Pageable page) {
        return categoryRepository.findAll(page);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()) {
            return category.get();
        }

        throw new ResourceNotFoundException("Category is not found for the id: " + id);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategoryById(Long id, Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        Category oldCategory = null;

        if(existingCategory.isPresent()) {
            oldCategory =  existingCategory.get();
        } else {
            return oldCategory;
        }

        oldCategory.setCategory_name(category.getCategory_name() != null ? category.getCategory_name() : oldCategory.getCategory_name());
        oldCategory.setCategory_description(category.getCategory_description() != null ? category.getCategory_description() : oldCategory.getCategory_description());

        return categoryRepository.save(oldCategory);
    }
}
