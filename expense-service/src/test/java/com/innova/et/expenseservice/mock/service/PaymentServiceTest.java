package com.innova.et.expenseservice.mock.service;


import com.innova.et.common.dto.MerchantDto;
import com.innova.et.expenseservice.beans.Payment;
import com.innova.et.expenseservice.dao.PaymentDao;
import com.innova.et.expenseservice.dto.PaymentDto;
import com.innova.et.expenseservice.exception.InvalidDataException;
import com.innova.et.expenseservice.feign.AdminServiceClient;
import com.innova.et.expenseservice.service.impl.PaymentServiceImpl;
import feign.FeignException;
import feign.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static com.innova.et.expenseservice.dto.PaymentDto.convert;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private PaymentDao paymentDao;
    @Mock
    private AdminServiceClient merchantClient;

    @Test
    void create() {
        List<String> paymentModes = Arrays.asList("Debit Card", "UPI", "Cash");
        Set<String> paymentModesSet = new HashSet<>(paymentModes);
        Date date = new Date();

        var request = new PaymentDto.PaymentDtoRequest();
        request.setMerchant("00000000000000");
        request.setPaymentDate(date);
        request.setAmount(100);
        request.setPaymentMode("UPI");
        request.setPaymentBy("Nirupam");
        Payment paymentR = convert(request);

        var payment = mock(Payment.class);
        var dtoResponse = mock(MerchantDto.MerchantDtoResponse.class);

        when(merchantClient.getMerchantById("00000000000000")).thenReturn(dtoResponse);
        when(dtoResponse.getAcceptedPaymentModes()).thenReturn(paymentModesSet);
        when(paymentDao.create(paymentR)).thenReturn(payment);
        when(payment.getId()).thenReturn("111111111111111");

        PaymentDto.PaymentDtoResponse response = paymentService.create(request);

        assertNotNull(response);
        assertNotNull(response.getPaymentId());
    }

    @Test
    void create_InvalidDataException() {
        List<String> paymentModes = Arrays.asList("Debit Card", "UPI", "Cash");
        Set<String> paymentModesSet = new HashSet<>(paymentModes);
        Date date = new Date();

        var request = new PaymentDto.PaymentDtoRequest();
        request.setMerchant("00000000000000");
        request.setPaymentDate(date);
        request.setAmount(100);
        request.setPaymentMode("EMI");
        request.setPaymentBy("Nirupam");

        var dtoResponse = mock(MerchantDto.MerchantDtoResponse.class);

        when(merchantClient.getMerchantById("00000000000000")).thenReturn(dtoResponse);
        when(dtoResponse.getAcceptedPaymentModes()).thenReturn(paymentModesSet);

        assertThrows(InvalidDataException.class, () -> paymentService.create(request));
    }

    @Test
    void create_FeignException404() {
        Date date = new Date();

        var request = new PaymentDto.PaymentDtoRequest();
        request.setMerchant("00000000000000");
        request.setPaymentDate(date);
        request.setAmount(100);
        request.setPaymentMode("EMI");
        request.setPaymentBy("Nirupam");

        var httpRequest = Request.create(Request.HttpMethod.GET, "", new HashMap<>(), "".getBytes(), null, null);

        doThrow(new FeignException.NotFound("", httpRequest, "".getBytes()))
                .when(merchantClient)
                .getMerchantById("00000000000000");

        assertThrows(InvalidDataException.class, () -> paymentService.create(request));
    }

    @Test
    void create_FeignException504() {
        Date date = new Date();

        var request = new PaymentDto.PaymentDtoRequest();
        request.setMerchant("00000000000000");
        request.setPaymentDate(date);
        request.setAmount(100);
        request.setPaymentMode("EMI");
        request.setPaymentBy("Nirupam");

        var httpRequest = Request.create(Request.HttpMethod.GET, "", new HashMap<>(), "".getBytes(), null, null);

        doThrow(new FeignException.GatewayTimeout("", httpRequest, "".getBytes()))
                .when(merchantClient)
                .getMerchantById("00000000000000");

        assertThrows(Exception.class, () -> paymentService.create(request));
    }

    @Test
    void findById() {
        assertNull(paymentService.findById("111111111111111"));
    }

    @Test
    void findAll() {
        when(paymentDao.findAll()).thenReturn(new ArrayList<>());

        assertEquals(0, paymentService.findAll().size());
    }

    @Test
    void update() {
        assertNull(paymentService.update("111111111111111", null));
    }

    @Test
    void remove() {
        paymentService.remove("111111111111111");
        paymentService.remove();

        assertTrue(true);
    }

}
