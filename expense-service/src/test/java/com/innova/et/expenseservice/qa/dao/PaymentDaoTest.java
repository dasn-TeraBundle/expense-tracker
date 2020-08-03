package com.innova.et.expenseservice.qa.dao;


import com.innova.et.expenseservice.beans.Payment;
import com.innova.et.expenseservice.dao.PaymentDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentDaoTest {

    @Autowired
    private PaymentDao paymentDao;

    private Payment payment1, payment2;

    @BeforeEach
    void init() {
        var payment1 = new Payment(new Date(), "000", 100, "UPI", "Nirupam");
        payment1.setReferenceNo("1000000000");
        var payment2 = new Payment(new Date(), "000", 100, "UPI", "Nirupam");
        payment2.setReferenceNo("1000000001");
        var payment3 = new Payment(new Date(), "000", 100, "UPI", "Nirupam");
        payment3.setReferenceNo("1000000002");

        this.payment1 = paymentDao.create(payment1);
        this.payment2 = paymentDao.create(payment2);
        paymentDao.create(payment3);
    }

    @Test
    void findById() {
        assertNotNull(paymentDao.findById(payment1.getId()));
        assertNull(paymentDao.findById("000"));
    }

    @Test
    void findAll() {
        assertEquals(3, paymentDao.findAll().size());
    }

    @Test
    void update() {
        assertNull(paymentDao.update("000", null));
    }

    @AfterEach
    void cleanup() {
        paymentDao.remove(payment1.getId());
        paymentDao.remove(payment2);
        paymentDao.remove();
    }
}
