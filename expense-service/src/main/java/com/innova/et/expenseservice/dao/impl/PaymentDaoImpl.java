package com.innova.et.expenseservice.dao.impl;

import com.innova.et.expenseservice.beans.Payment;
import com.innova.et.expenseservice.dao.PaymentDao;
import com.innova.et.expenseservice.dao.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentDaoImpl implements PaymentDao {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentDaoImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment create(Payment item) {
        return paymentRepository.save(item);
    }

    @Override
    public Payment findById(String s) {
        return paymentRepository.findById(s).orElse(null);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment update(String s, Payment item) {
        return null;
    }

    @Override
    public void remove(String s) {
        paymentRepository.deleteById(s);
    }

    @Override
    public void remove(Payment item) {

    }

    @Override
    public void remove() {
        paymentRepository.deleteAll();
    }
}
