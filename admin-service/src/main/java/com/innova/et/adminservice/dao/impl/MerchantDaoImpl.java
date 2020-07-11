package com.innova.et.adminservice.dao.impl;

import com.innova.et.adminservice.beans.Category;
import com.innova.et.adminservice.beans.Merchant;
import com.innova.et.adminservice.dao.MerchantDao;
import com.innova.et.adminservice.dao.repository.CategoryRepository;
import com.innova.et.adminservice.dao.repository.MerchantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantDaoImpl implements MerchantDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantDaoImpl.class);

    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantDaoImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    @CacheEvict(cacheNames = "merchants", key = "'ALL_MERCHANTS'")
    public Merchant create(Merchant category) {
        return merchantRepository.insert(category);
    }

    @Override
    @Cacheable(cacheNames = "merchants", key = "#id")
    public Merchant findById(String id) {
        LOGGER.info("Fetching data from db");
        return merchantRepository.findById(id).orElse(null);
    }

    @Override
    @Cacheable(cacheNames = "merchants", key = "'ALL_MERCHANTS'")
    public List<Merchant> findAll() {
        LOGGER.info("Fetching data from db");
        return merchantRepository.findAll();
    }

    @Override
    @Caching(put = {
            @CachePut(cacheNames = "merchants", key = "#id"),
            @CachePut(cacheNames = "merchants", key = "#item.name")
    }, evict = {
            @CacheEvict(cacheNames = "merchants", key = "'ALL_MERCHANTS'")
    })
    public Merchant update(String id, Merchant item) {
        return merchantRepository.save(item);
    }

    @Override
//    @Caching(evict = {
////            @CacheEvict(cacheNames = "merchants", key = "#id"),
////            @CacheEvict(cacheNames = "merchants", key = "'ALL_MERCHANTS'")
////    })
    public void remove(String id) {
//        categoryRepository.deleteById(id);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "merchants", key = "#item.id"),
            @CacheEvict(cacheNames = "merchants", key = "#item.name"),
            @CacheEvict(cacheNames = "merchants", key = "'ALL_MERCHANTS'")
    })
    public void remove(Merchant item) {
        merchantRepository.delete(item);
    }

    @Override
    @CacheEvict(cacheNames = "merchants", allEntries = true)
    public void remove() {
        merchantRepository.deleteAll();
    }

}
