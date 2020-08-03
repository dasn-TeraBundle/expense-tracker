package com.innova.et.adminservice.qa.dao;


import com.innova.et.adminservice.beans.PaymentMode;
import com.innova.et.adminservice.dao.PaymentModeDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentModeDaoTest {

    @Autowired
    private PaymentModeDao paymentModeDao;

    private PaymentMode paymentMode;

    @BeforeEach
    void init() {
        paymentMode = new PaymentMode("Card");
        paymentMode = paymentModeDao.create(paymentMode);
    }

    @Test
    void findById() {
        assertNull(paymentModeDao.findById("000"));
    }

    @Test
    void update() {
        assertNull(paymentModeDao.update("000", null));
    }

    @Test
    void findAll() {
        assertEquals(1, paymentModeDao.findAll().size());
    }

    @Test
    void removeById() {
        assertThrows(UnsupportedOperationException.class, () -> paymentModeDao.remove("000"));
    }

    @Test
    void removeByItem() {
        assertThrows(UnsupportedOperationException.class, () -> paymentModeDao.remove(paymentMode));
    }

    @AfterEach
    void cleanup() {
        paymentModeDao.remove();
    }
}
