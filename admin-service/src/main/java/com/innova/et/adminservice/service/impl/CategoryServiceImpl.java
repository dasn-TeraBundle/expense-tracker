package com.innova.et.adminservice.service.impl;

import com.innova.et.adminservice.beans.Category;
import com.innova.et.adminservice.dao.CategoryDao;
import com.innova.et.adminservice.exception.CategoryNotFoundException;
import com.innova.et.adminservice.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innova.et.adminservice.dto.CategoryDto.convert;
import static com.innova.et.common.dto.CategoryDto.CategoryDtoRequest;
import static com.innova.et.common.dto.CategoryDto.CategoryDtoResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public CategoryDtoResponse create(CategoryDtoRequest category) {
        LOGGER.debug("Creating new category");
        return convert(categoryDao.create(convert(category)));
    }

    @Override
    public CategoryDtoResponse findByName(String name) {
        return convert(categoryDao.findByName(name));
    }

    @Override
    public CategoryDtoResponse findById(String id) {
        return convert(categoryDao.findById(id));
    }

    @Override
    public List<CategoryDtoResponse> findAll() {
        return convert(categoryDao.findAll());
    }

    @Override
    public List<CategoryDtoResponse> findAllById_Name() {
        return convert(categoryDao.findAllById_Name());
    }

    @Override
    public CategoryDtoResponse update(String id, CategoryDtoRequest item) {
        Category category = categoryDao.findById(id);
        if (category == null) {
            throw new CategoryNotFoundException();
        }

        if (category.getChildren() == null)
            category.setChildren(item.getSubCategories());
        else
            category.getChildren().addAll(item.getSubCategories());
        return convert(categoryDao.update(id, category));
    }

    @Override
    public void remove(String id) {
        Category category = categoryDao.findById(id);
        if (category == null) {
            throw new CategoryNotFoundException();
        }

        categoryDao.remove(category);
    }

    @Override
    public void remove(CategoryDtoRequest item) {
        categoryDao.remove(convert(item));
    }

    @Override
    public void remove() {
        categoryDao.remove();
    }
}
