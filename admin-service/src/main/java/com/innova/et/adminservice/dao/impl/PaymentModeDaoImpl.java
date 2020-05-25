package com.innova.et.adminservice.dao.impl;

import com.innova.et.adminservice.beans.PaymentMode;
import com.innova.et.adminservice.dao.PaymentModeDao;
import com.innova.et.adminservice.dao.repository.PaymentModeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentModeDaoImpl implements PaymentModeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentModeDaoImpl.class);

    private PaymentModeRepository paymentModeRepository;

    @Autowired
    public PaymentModeDaoImpl(PaymentModeRepository paymentModeRepository) {
        this.paymentModeRepository = paymentModeRepository;
    }

    @Override
    @CacheEvict(cacheNames = "payments", key = "'ALL_PAYMENTS'")
    public PaymentMode create(PaymentMode item) {
        return paymentModeRepository.insert(item);
    }

    @Override
    public PaymentMode findById(String s) {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "payments", key = "'ALL_PAYMENTS'")
    public List<PaymentMode> findAll() {
        LOGGER.info("Fetching from db");
        return paymentModeRepository.findAll();
    }

    @Override
    public PaymentMode update(String s, PaymentMode item) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public void remove(PaymentMode item) {

    }

    @Override
    @CacheEvict(cacheNames = "payments", allEntries = true)
    public void remove() {
        paymentModeRepository.deleteAll();
    }
}
