package com.innova.et.expenseservice.service.impl;

import com.innova.et.expenseservice.dao.ExpenseDao;
import com.innova.et.expenseservice.feign.CategoryClient;
import com.innova.et.expenseservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innova.et.expenseservice.dto.ExpenseDto.*;

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
    public ExpenseDtoResponse create(ExpenseDtoRequest expense) {
//        try {
//            System.out.println(categoryClient.getById(expense.getCategory()));
//        } catch (FeignException ex) {
//            if (ex.status() == 404)
//                throw new IllegalArgumentException("Invalid category");
//            else throw ex;
//        }
        return convert(expenseDao.create(convert(expense)));
    }

    @Override
    public ExpenseDtoResponse findById(String s) {
        return null;
    }

    @Override
    public List<ExpenseDtoResponse> findAll() {
//        new Sort(Sort.Direction.ASC, Arrays.asList("date"))
        return convert(expenseDao.findAll());
    }

    @Override
    public ExpenseDtoResponse update(String s, ExpenseDtoRequest item) {
        return null;
    }

    @Override
    public void remove(String id) {
        expenseDao.remove(id);
    }

    @Override
    public void remove(ExpenseDtoRequest item) {

    }

    @Override
    public void remove() {
        expenseDao.remove();
    }
}
