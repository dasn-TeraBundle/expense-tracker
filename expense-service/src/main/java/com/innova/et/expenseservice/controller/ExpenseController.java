package com.innova.et.expenseservice.controller;

import com.innova.et.expenseservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.innova.et.expenseservice.dto.ExpenseDto.ExpenseDtoRequest;
import static com.innova.et.expenseservice.dto.ExpenseDto.ExpenseDtoResponse;

@RestController
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/expense")
    public ExpenseDtoResponse create(@RequestBody ExpenseDtoRequest exp) {
        return expenseService.create(exp);
    }

    @GetMapping("/expense")
    public List<ExpenseDtoResponse> list() {
        return expenseService.findAll();
    }


    @DeleteMapping("/expense/{id}")
    public void delete(@PathVariable String id) {
        expenseService.remove(id);
    }
}
