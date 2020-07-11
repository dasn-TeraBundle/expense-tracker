package com.innova.et.adminservice.dao.impl;

import com.innova.et.adminservice.beans.Category;
import com.innova.et.adminservice.dao.CategoryDao;
import com.innova.et.adminservice.dao.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDaoImpl implements CategoryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDaoImpl.class);

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDaoImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES'"),
            @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES2'")
    })
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
    public Category findById_Name(String id) {
        throw new UnsupportedOperationException("Operation not supported currently");
    }

    @Override
    @Cacheable(cacheNames = "categories", key = "'ALL_CATEGORIES'")
    public List<Category> findAll() {
        LOGGER.info("Fetching data from db");
        return categoryRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "categories", key = "'ALL_CATEGORIES2'")
    public List<Category> findAllById_Name() {
        LOGGER.info("Fetching data from db");
        return categoryRepository.findAllById_Name().collect(Collectors.toList());
    }

    @Override
    @Caching(put = {
            @CachePut(cacheNames = "categories", key = "#id"),
            @CachePut(cacheNames = "categories", key = "#item.name")
    }, evict = {
            @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES'"),
            @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES2'")
    })
    public Category update(String id, Category item) {
        return categoryRepository.save(item);
    }

    @Override
//    @Caching(evict = {
////            @CacheEvict(cacheNames = "categories", key = "#id"),
////            @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES'")
////    })
    public void remove(String id) {
//        categoryRepository.deleteById(id);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "categories", key = "#item.id"),
            @CacheEvict(cacheNames = "categories", key = "#item.name"),
            @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES'"),
            @CacheEvict(cacheNames = "categories", key = "'ALL_CATEGORIES2'")
    })
    public void remove(Category item) {
        categoryRepository.delete(item);
    }

    @Override
    @CacheEvict(cacheNames = "categories", allEntries = true)
    public void remove() {
        categoryRepository.deleteAll();
    }

}
