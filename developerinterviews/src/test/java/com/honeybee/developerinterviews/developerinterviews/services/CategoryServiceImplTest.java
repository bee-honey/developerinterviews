package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.entities.Category;
import com.honeybee.developerinterviews.developerinterviews.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category();
        category.setId(1L);
        category.setCategoryName("Java");
        category.setCategoryDescription("Java Programming Language");
    }

    @Test
    void getAllCategories() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Category> page = new PageImpl<>(Arrays.asList(category));

        when(categoryRepository.findAll(pageable)).thenReturn(page);

        Page<Category> result = categoryService.getAllCategories(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(categoryRepository, times(1)).findAll(pageable);
    }

    @Test
    void addCategory() {
        Pageable pageable = PageRequest.of(0,5);
        Page<Category> page = new PageImpl<>(Arrays.asList(category));


        Category category = new Category();
        category.setId(1L);
        category.setCategoryName("K8s");
        category.setCategoryDescription("Kubernetes");

        when(categoryRepository.save(category)).thenReturn(category);

        Category result = categoryService.addCategory(category);

        assertNotNull(result);
        assertEquals("K8s", result.getCategoryName());
        verify(categoryRepository, times(1)).save(category);
    }
}
