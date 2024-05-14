package com.honeybee.developerinterviews.developerinterviews.controllers;

import com.honeybee.developerinterviews.developerinterviews.entities.Category;
import com.honeybee.developerinterviews.developerinterviews.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(Pageable page) {
        return categoryService.getAllCategories(page).toList();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/categories")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@RequestParam Long id) {
        categoryService.deleteCategoryById(id);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategoryById(@PathVariable("id") Long id, @RequestBody Category expense) {
        return categoryService.updateCategoryById(id, expense);
    }
}
