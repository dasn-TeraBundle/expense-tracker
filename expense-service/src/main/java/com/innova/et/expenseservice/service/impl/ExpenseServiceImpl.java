package com.innova.et.expenseservice.service.impl;

import com.innova.et.expenseservice.dao.ExpenseDao;
import com.innova.et.expenseservice.exception.InvalidDataException;
import com.innova.et.expenseservice.feign.AdminServiceClient;
import com.innova.et.expenseservice.service.ExpenseService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innova.et.common.dto.CategoryDto.CategoryDtoResponse;
import static com.innova.et.expenseservice.dto.ExpenseDto.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseDao expenseDao;
    private final AdminServiceClient adminServiceClient;

    @Autowired
    public ExpenseServiceImpl(ExpenseDao expenseDao, AdminServiceClient adminServiceClient) {
        this.expenseDao = expenseDao;
        this.adminServiceClient = adminServiceClient;
    }

    @Override
    public ExpenseDtoResponse create(ExpenseDtoRequest expense) {
        try {
            CategoryDtoResponse dtoResponse = adminServiceClient.getCategoryById(expense.getCategory());
            if (!dtoResponse.getSubCategories().contains(expense.getSubCategory())) {
                throw new InvalidDataException("Invalid subcategory for given category");
            }
        } catch (FeignException ex) {
            if (ex.status() == 404)
                throw new InvalidDataException("Invalid category");
            else throw ex;
        }
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
