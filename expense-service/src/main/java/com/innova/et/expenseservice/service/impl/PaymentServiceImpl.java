package com.innova.et.expenseservice.service.impl;

import com.innova.et.expenseservice.beans.Payment;
import com.innova.et.expenseservice.repository.PaymentRepository;
import com.innova.et.expenseservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findById(String s) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
//        var sort = new Sort(Sort.Direction.ASC, Arrays.asList("date"));
        return paymentRepository.findAll();
    }

    @Override
    public Payment update(String s, Payment item) {
        return null;
    }

    @Override
    public void remove(String id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public void remove(Payment payment) {

    }

    @Override
    public void remove() {

    }
}
