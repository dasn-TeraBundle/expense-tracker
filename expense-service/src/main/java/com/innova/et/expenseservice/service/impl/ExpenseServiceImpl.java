package com.innova.et.expenseservice.service.impl;

import com.innova.et.expenseservice.beans.Expense;
import com.innova.et.expenseservice.dao.ExpenseDao;
import com.innova.et.expenseservice.feign.CategoryClient;
import com.innova.et.expenseservice.service.ExpenseService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDao expenseDao;
    private CategoryClient categoryClient;

    @Autowired
    public ExpenseServiceImpl(ExpenseDao expenseDao, CategoryClient categoryClient) {
        this.expenseDao = expenseDao;
        this.categoryClient = categoryClient;
    }

    @Override
    public Expense create(Expense expense) {
//        try {
//            System.out.println(categoryClient.getById(expense.getCategory()));
//        } catch (FeignException ex) {
//            if (ex.status() == 404)
//                throw new IllegalArgumentException("Invalid category");
//            else throw ex;
//        }
        return expenseDao.create(expense);
    }

    @Override
    public Expense findById(String s) {
        return null;
    }

    @Override
    public List<Expense> findAll() {
//        new Sort(Sort.Direction.ASC, Arrays.asList("date"))
        return expenseDao.findAll();
    }

    @Override
    public Expense update(String s, Expense item) {
        return null;
    }

    @Override
    public void remove(String id) {
        expenseDao.remove(id);
    }

    @Override
    public void remove(Expense item) {

    }

    @Override
    public void remove() {
        expenseDao.remove();
    }
}
