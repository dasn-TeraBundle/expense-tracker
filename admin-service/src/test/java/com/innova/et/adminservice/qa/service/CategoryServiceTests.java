package com.innova.et.adminservice.qa.service;

import com.innova.et.adminservice.service.CategoryService;
import com.innova.et.common.dto.CategoryDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class CategoryServiceTests {

    @Autowired
    private CategoryService categoryService;

    @BeforeEach
    void setup() {
        CategoryDto.CategoryDtoRequest request = new CategoryDto.CategoryDtoRequest();
        request.setCategoryName("Travel");
        categoryService.create(request);
    }

    @Test
    void findAll() {
        Assertions.assertEquals(1, categoryService.findAll().size());
        Assertions.assertEquals("Travel", categoryService.findAll().get(0).getCategoryName());
    }

    @Test
    @Timeout(value = 1)
    void findAll_time() {
        categoryService.findAll();
    }

    @AfterEach
    void cleanup() {
        categoryService.remove();
    }
}
