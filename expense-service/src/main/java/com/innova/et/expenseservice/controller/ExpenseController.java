package com.innova.et.expenseservice.controller;

import com.innova.et.expenseservice.beans.Expense;
import com.innova.et.expenseservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expense")
    public Expense create(@RequestBody Expense exp) {
        return expenseService.create(exp);
    }

    @GetMapping("/expense")
    public List<Expense> list() {
        return expenseService.findAll();
    }


    @DeleteMapping("/expense/{id}")
    public void delete(@PathVariable String id) {
        expenseService.remove(id);
    }
}
