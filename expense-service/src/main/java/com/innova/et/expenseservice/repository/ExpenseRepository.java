package com.innova.et.expenseservice.repository;

import com.innova.et.expenseservice.beans.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    //Stream<Expense> findAll();
}
