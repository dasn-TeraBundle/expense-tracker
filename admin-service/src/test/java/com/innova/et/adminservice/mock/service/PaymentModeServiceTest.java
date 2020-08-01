package com.innova.et.adminservice.mock.service;


import com.innova.et.adminservice.beans.PaymentMode;
import com.innova.et.adminservice.dao.PaymentModeDao;
import com.innova.et.adminservice.service.impl.PaymentModeServiceImpl;
import com.innova.et.common.dto.PaymentModeDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static com.innova.et.adminservice.dto.PaymentModeDto.convert;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class PaymentModeServiceTest {

    @InjectMocks
    private PaymentModeServiceImpl paymentModeService;

    @Mock
    private PaymentModeDao paymentModeDao;

    @Test
    void create() {
        var request = new PaymentModeDto.PaymentModeDtoRequest();
        request.setPaymentMode("UPI");
        PaymentMode paymentR = convert(request);
        var payment = mock(PaymentMode.class);

        when(paymentModeDao.create(paymentR)).thenReturn(payment);
        when(payment.getMode()).thenReturn("UPI");

        PaymentModeDto.PaymentModeDtoResponse response = paymentModeService.create(request);

        assertNotNull(response);
        assertEquals(request.getPaymentMode(), response.getPaymentMode());
    }

    @Test
    void findById() {
        assertNull(paymentModeService.findById("00000000000000"));
    }

    @Test
    void findAll() {
        when(paymentModeDao.findAll()).thenReturn(new ArrayList<>());

        assertEquals(0, paymentModeService.findAll().size());
    }

    @Test
    void update() {
        assertNull(paymentModeService.update("00000000000000", null));
    }

    @Test
    void remove() {
        paymentModeService.remove("");
        paymentModeService.remove(new PaymentModeDto.PaymentModeDtoRequest());
        paymentModeService.remove();

        assertTrue(true);
    }
}
