package com.innova.et.expenseservice.service.impl;

import com.innova.et.expenseservice.dao.PaymentDao;
import com.innova.et.expenseservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innova.et.expenseservice.dto.PaymentDto.*;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public PaymentDtoResponse create(PaymentDtoRequest payment) {
        return convert(paymentDao.create(convert(payment)));
    }

    @Override
    public PaymentDtoResponse findById(String s) {
        return null;
    }

    @Override
    public List<PaymentDtoResponse> findAll() {
//        var sort = new Sort(Sort.Direction.ASC, Arrays.asList("date"));
        return convert(paymentDao.findAll());
    }

    @Override
    public PaymentDtoResponse update(String s, PaymentDtoRequest item) {
        return null;
    }

    @Override
    public void remove(String id) {
        paymentDao.remove(id);
    }

    @Override
    public void remove(PaymentDtoRequest payment) {

    }

    @Override
    public void remove() {

    }
}
