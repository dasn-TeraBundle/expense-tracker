package com.innova.et.adminservice.mock.service;


import com.innova.et.adminservice.beans.Category;
import com.innova.et.adminservice.dao.impl.CategoryDaoImpl;
import com.innova.et.adminservice.exception.CategoryNotFoundException;
import com.innova.et.adminservice.service.impl.CategoryServiceImpl;
import com.innova.et.common.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static com.innova.et.adminservice.dto.CategoryDto.convert;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTests {

    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryDaoImpl categoryDao;

    @Test
    void create() {
        var request = new CategoryDto.CategoryDtoRequest();
        request.setCategoryName("Travel");
        Category categoryR = convert(request);
        var category = mock(Category.class);

        when(categoryDao.create(categoryR)).thenReturn(category);
        when(category.getId()).thenReturn("00000000000000");
        when(category.getName()).thenReturn("Travel");

        CategoryDto.CategoryDtoResponse response = categoryService.create(request);

        assertNotNull(response);
        assertNotNull(category.getId());
        assertEquals(request.getCategoryName(), response.getCategoryName());
    }

    @Test
    void findByName() {
        var category = mock(Category.class);

        when(categoryDao.findByName("Travel")).thenReturn(category);
        when(category.getId()).thenReturn("00000000000000");
        when(category.getName()).thenReturn("Travel");

        CategoryDto.CategoryDtoResponse response = categoryService.findByName("Travel");

        assertNotNull(response);
        assertNotNull(category.getId());
        assertEquals("Travel", response.getCategoryName());
    }

    @Test
    void findByName_Exception() {
        when(categoryDao.findByName("Travel")).thenReturn(null);

        assertThrows(CategoryNotFoundException.class, () -> categoryService.findByName("Travel"));
    }

    @Test
    void findById() {
        var category = mock(Category.class);

        when(categoryDao.findById("00000000000000")).thenReturn(category);
        when(category.getId()).thenReturn("00000000000000");
        when(category.getName()).thenReturn("Travel");

        CategoryDto.CategoryDtoResponse response = categoryService.findById("00000000000000");

        assertNotNull(response);
        assertNotNull(category.getName());
        assertEquals("00000000000000", response.getId());
    }

    @Test
    void findById_Exception() {
        when(categoryDao.findById("00000000000000")).thenReturn(null);

        assertThrows(CategoryNotFoundException.class, () -> categoryService.findById("00000000000000"));
    }

    @Test
    void findAll() {
        when(categoryDao.findAll()).thenReturn(new ArrayList<>());
        assertEquals(0, categoryService.findAll().size());
    }

    @Test
    void findAllById_Name() {
        when(categoryDao.findAllById_Name()).thenReturn(new ArrayList<>());
        assertEquals(0, categoryService.findAllById_Name().size());
    }

    @Test
    void update() {
        var request = new CategoryDto.CategoryDtoRequest();
        request.setCategoryName("Travel");
        List<String> c = Arrays.asList("Bus", "Cab");
        Set<String> children = new HashSet<>(c);
        request.setSubCategories(children);
        var category = new Category("Travel");//mock(Category.class);

        when(categoryDao.findById("00000000000000")).thenReturn(category);
        when(categoryDao.update("00000000000000", category)).thenReturn(category);

        CategoryDto.CategoryDtoResponse response = categoryService.update("00000000000000", request);

        assertNotNull(response);
        assertTrue(response.getSubCategories().contains("Bus"));
    }

    @Test
    void update_Exception() {
        var request = new CategoryDto.CategoryDtoRequest();
        request.setCategoryName("Travel");
        List<String> c = Arrays.asList("Bus", "Cab");
        Set<String> children = new HashSet<>(c);
        request.setSubCategories(children);

        when(categoryDao.findById("00000000000000")).thenReturn(null);

        assertThrows(CategoryNotFoundException.class, () -> categoryService.update("00000000000000", request));
    }

    @Test
    void remove() {
        var category = mock(Category.class);

        when(categoryDao.findById("00000000000000")).thenReturn(category);

        categoryService.remove("00000000000000");
        categoryService.remove(new CategoryDto.CategoryDtoRequest());
        categoryService.remove();
        assertTrue(true);
    }

    @Test
    void remove_Exception() {
        when(categoryDao.findById("00000000000000")).thenReturn(null);

        assertThrows(CategoryNotFoundException.class, () -> categoryService.remove("00000000000000"));
    }

}
