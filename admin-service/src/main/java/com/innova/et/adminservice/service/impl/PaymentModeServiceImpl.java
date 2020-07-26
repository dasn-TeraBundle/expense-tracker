package com.innova.et.adminservice.service.impl;

import com.innova.et.adminservice.dao.PaymentModeDao;
import com.innova.et.adminservice.service.PaymentModeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innova.et.adminservice.dto.PaymentModeDto.convert;
import static com.innova.et.common.dto.PaymentModeDto.PaymentModeDtoRequest;
import static com.innova.et.common.dto.PaymentModeDto.PaymentModeDtoResponse;

@Service
public class PaymentModeServiceImpl implements PaymentModeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentModeServiceImpl.class);

    private final PaymentModeDao paymentModeDao;

    @Autowired
    public PaymentModeServiceImpl(PaymentModeDao paymentModeDao) {
        this.paymentModeDao = paymentModeDao;
    }

    @Override
    public PaymentModeDtoResponse create(PaymentModeDtoRequest item) {
        LOGGER.debug("Creating new payment mode");
        return convert(paymentModeDao.create(convert(item)));
    }

    @Override
    public PaymentModeDtoResponse findById(String s) {
        return null;
    }

    @Override
    public List<PaymentModeDtoResponse> findAll() {
        return convert(paymentModeDao.findAll());
    }

    @Override
    public PaymentModeDtoResponse update(String s, PaymentModeDtoRequest item) {
        return null;
    }

    @Override
    public void remove(String s) {
        paymentModeDao.remove(s);
    }

    @Override
    public void remove(PaymentModeDtoRequest item) {
        paymentModeDao.remove(convert(item));
    }

    @Override
    public void remove() {
        paymentModeDao.remove();
    }
}
