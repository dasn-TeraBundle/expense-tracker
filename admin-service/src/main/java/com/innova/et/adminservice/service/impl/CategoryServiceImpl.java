package com.innova.et.adminservice.service.impl;

import com.innova.et.adminservice.beans.Category;
import com.innova.et.adminservice.exception.CategoryNotFoundException;
import com.innova.et.adminservice.repository.CategoryRepository;
import com.innova.et.adminservice.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private CategoryRepository categoryRepository;

    @Resource
    private CategoryService self;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES'")
    public Category create(Category category) {
        return categoryRepository.insert(category);
    }

    @Override
    @Cacheable(cacheNames = "categories", key = "#name")
    public Category findByName(String name) {
        LOGGER.info("Fetching data from db");
        return categoryRepository.findByName(name);
    }

    @Override
    @Cacheable(cacheNames = "categories", key = "#id")
    public Category findById(String id) {
        LOGGER.info("Fetching data from db");
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    @Cacheable(cacheNames = "categories", key = "'ALL_CATEGORIES'")
    public List<Category> findAll() {
        LOGGER.info("Fetching data from db");
        return categoryRepository.findAll();
    }

    @Override
    @CachePut(cacheNames = "categories", key = "{#id, #item.name}")
    public Category update(String id, Category item) {
        Category category = findById(id);
        if (category == null) {
            throw new CategoryNotFoundException();
        }

        category.getChildren().addAll(item.getChildren());
        return categoryRepository.save(category);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "categories", key = "#id"),
            @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES'")
    })
    public void remove(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @CacheEvict(cacheNames = "categories", key = "{#item.id, #item.name, 'ALL_CATEGORIES'}")
    public void remove(Category item) {
        categoryRepository.delete(item);
    }

    @Override
    @CacheEvict(cacheNames = "categories", allEntries = true)
    public void remove() {
        categoryRepository.deleteAll();
    }
}
