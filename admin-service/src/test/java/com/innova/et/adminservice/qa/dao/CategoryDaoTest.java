package com.innova.et.adminservice.qa.dao;


import com.innova.et.adminservice.beans.Category;
import com.innova.et.adminservice.dao.CategoryDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;

    private Category category;

    @BeforeEach
    void init() {
        category = new Category("Travel");
        category = categoryDao.create(category);
    }

    @Test
    void findById_Name() {
        assertThrows(UnsupportedOperationException.class, () -> categoryDao.findById_Name(""));
    }

    @Test
    void remove() {
        assertThrows(UnsupportedOperationException.class, () -> categoryDao.remove("000"));
    }

    @AfterEach
    void cleanup() {
        categoryDao.remove(category);
    }
}
