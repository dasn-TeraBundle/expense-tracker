package com.innova.et.expenseservice.service.impl;

import com.innova.et.expenseservice.beans.Expense;
import com.innova.et.expenseservice.feign.CategoryClient;
import com.innova.et.expenseservice.repository.ExpenseRepository;
import com.innova.et.expenseservice.service.ExpenseService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryClient categoryClient;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryClient categoryClient) {
        this.expenseRepository = expenseRepository;
        this.categoryClient = categoryClient;
    }

    @Override
    public Expense create(Expense expense) {
        try {
            System.out.println(categoryClient.getById(expense.getCategory()));
        } catch (FeignException ex) {
            if (ex.status() == 404)
                throw new IllegalArgumentException("Invalid category");
            else throw ex;
        }
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
