package com.innova.et.expenseservice.service;

import com.innova.et.common.service.GenericService;

import static com.innova.et.expenseservice.dto.ExpenseDto.ExpenseDtoRequest;
import static com.innova.et.expenseservice.dto.ExpenseDto.ExpenseDtoResponse;

public interface ExpenseService extends GenericService<ExpenseDtoRequest, ExpenseDtoResponse, String> {
}
