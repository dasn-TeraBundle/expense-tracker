package com.innova.et.adminservice.qa.dao;


import com.innova.et.adminservice.beans.Merchant;
import com.innova.et.adminservice.dao.MerchantDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MerchantDaoTest {

    @Autowired
    private MerchantDao merchantDao;

    private Merchant merchant;

    @BeforeEach
    void init() {
        Set<String> paymentModesSet = new HashSet<>(Arrays.asList("Card", "Cash", "UPI"));
        var merchant1 = new Merchant("Zomato", paymentModesSet);
        var merchant2 = new Merchant("Zomato", paymentModesSet);

        this.merchant = merchantDao.create(merchant1);
        merchantDao.create(merchant2);
    }

    @Test
    void findById() {
        assertNotNull(merchantDao.findById(merchant.getId()));
        assertNull(merchantDao.findById("000"));
    }

    @Test
    void findAll() {
        assertEquals(2, merchantDao.findAll().size());
    }

    @Test
    void update() {
        merchant.getPaymentModes().add("Wallet");
        merchant = merchantDao.update(merchant.getId(), merchant);
        assertTrue(merchant.getPaymentModes().contains("Wallet"));
    }

    @Test
    void remove() {
        assertThrows(UnsupportedOperationException.class, () -> merchantDao.remove("000"));
    }

    @AfterEach
    void cleanup() {
        merchantDao.remove(merchant);
        merchantDao.remove();
    }
}
