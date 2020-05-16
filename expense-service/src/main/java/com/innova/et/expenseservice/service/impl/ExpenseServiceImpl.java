package com.innova.et.expenseservice.service.impl;

import com.innova.et.expenseservice.beans.Expense;
import com.innova.et.expenseservice.repository.ExpenseRepository;
import com.innova.et.expenseservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense create(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense findById(String s) {
        return null;
    }

    @Override
    public List<Expense> findAll() {
//        new Sort(Sort.Direction.ASC, Arrays.asList("date"))
        return expenseRepository.findAll();
    }

    @Override
    public Expense update(String s, Expense item) {
        return null;
    }

    @Override
    public void remove(String id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public void remove(Expense item) {

    }

    @Override
    public void remove() {
        expenseRepository.deleteAll();
    }
}
