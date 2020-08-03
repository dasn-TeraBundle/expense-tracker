package com.innova.et.expenseservice.qa.dao;


import com.innova.et.expenseservice.beans.Expense;
import com.innova.et.expenseservice.dao.ExpenseDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class ExpenseDaoTest {

    @Autowired
    private ExpenseDao expenseDao;

    private Expense expense1, expense2;

    @BeforeEach
    void init() {
        var expense1 = new Expense(new Date(), "000", "", 100, "111");
        expense1.setSubCategory("Cab");
        var expense2 = new Expense(new Date(), "000", "", 100, "111");
        expense2.setSubCategory("Cab");
        var expense3 = new Expense(new Date(), "000", "", 100, "111");
        expense3.setSubCategory("Cab");

        this.expense1 = expenseDao.create(expense1);
        this.expense2 = expenseDao.create(expense2);
        expenseDao.create(expense3);
    }

    @Test
    void findById() {
        assertNull(expenseDao.findById("101"));
    }

    @Test
    void findAll() {
        assertEquals(3, expenseDao.findAll().size());
    }

    @Test
    void update() {
        assertNull(expenseDao.update("101", null));
    }

    @AfterEach
    void cleanup() {
        expenseDao.remove(expense1.getId());
        expenseDao.remove(expense2);
        expenseDao.remove();
    }
}
