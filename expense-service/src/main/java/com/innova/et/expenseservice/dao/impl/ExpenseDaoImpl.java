package com.innova.et.expenseservice.dao.impl;

import com.innova.et.expenseservice.beans.Expense;
import com.innova.et.expenseservice.dao.ExpenseDao;
import com.innova.et.expenseservice.dao.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpenseDaoImpl implements ExpenseDao {

    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseDaoImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    @CacheEvict(cacheNames = "expenses", allEntries = true)
    public Expense create(Expense item) {
        return expenseRepository.save(item);
    }

    @Override
    public Expense findById(String s) {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "expenses", key = "'ALL_EXPENSES'")
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense update(String s, Expense item) {
        return null;
    }

    @Override
    @CacheEvict(cacheNames = "expenses", allEntries = true)
    public void remove(String id) {
        expenseRepository.deleteById(id);
    }

    @Override
    @CacheEvict(cacheNames = "expenses", allEntries = true)
    public void remove(Expense item) {
        expenseRepository.delete(item);
    }

    @Override
    @CacheEvict(cacheNames = "expenses", allEntries = true)
    public void remove() {
        expenseRepository.deleteAll();
    }
}
