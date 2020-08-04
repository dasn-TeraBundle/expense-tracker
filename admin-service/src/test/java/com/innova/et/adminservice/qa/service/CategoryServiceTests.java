package com.innova.et.adminservice.qa.service;

import com.innova.et.adminservice.service.CategoryService;
import com.innova.et.common.dto.CategoryDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTests {

    @Autowired
    private CategoryService categoryService;

    private CategoryDto.CategoryDtoResponse dtoResponse;

    @BeforeEach
    void setup() {
        var request = new CategoryDto.CategoryDtoRequest();
        request.setCategoryName("Travel");
        request.setSubCategories(new HashSet<>(Arrays.asList("Bus", "Cab", "Train")));
        dtoResponse = categoryService.create(request);
    }

    @Test
    void findByName() {
        assertNotNull(categoryService.findByName("Travel"));
    }

    @Test
    void findById() {
        assertNotNull(categoryService.findById(dtoResponse.getId()));
    }

    @Test
    void findAll() {
        assertEquals(1, categoryService.findAll().size());
        assertEquals("Travel", categoryService.findAll().get(0).getCategoryName());
    }

    @Test
    @Timeout(value = 1)
    void findAll_time() {
        categoryService.findAll();
        assertTrue(true);
    }

    @Test
    void findAllById_Name() {
        assertNull(categoryService.findAllById_Name().get(0).getSubCategories());
    }

    @Test
    void update() {
        var request = new CategoryDto.CategoryDtoRequest();
        request.setCategoryName("Travel");
        request.setSubCategories(new HashSet<>(Arrays.asList("Plane")));

        assertTrue(categoryService.update(dtoResponse.getId(), request).getSubCategories().contains("Plane"));
    }

    @AfterEach
    void cleanup() {
        categoryService.remove();
    }
}
