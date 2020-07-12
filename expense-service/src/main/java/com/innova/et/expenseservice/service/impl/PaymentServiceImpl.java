package com.innova.et.expenseservice.service.impl;

import com.innova.et.common.dto.MerchantDto;
import com.innova.et.expenseservice.dao.PaymentDao;
import com.innova.et.expenseservice.exception.InvalidDataException;
import com.innova.et.expenseservice.feign.AdminServiceClient;
import com.innova.et.expenseservice.service.PaymentService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innova.et.expenseservice.dto.PaymentDto.*;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;
    private final AdminServiceClient merchantClient;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao, AdminServiceClient merchantClient) {
        this.paymentDao = paymentDao;
        this.merchantClient = merchantClient;
    }

    @Override
    public PaymentDtoResponse create(PaymentDtoRequest payment) {
        try {
            MerchantDto.MerchantDtoResponse response = merchantClient.getMerchantById(payment.getMerchant());
            if (!response.getAcceptedPaymentModes().contains(payment.getPaymentMode())) {
                throw new InvalidDataException("Payment method not accepted by merchant");
            }
        } catch (FeignException ex) {
            if (ex.status() == 404) {
                throw new InvalidDataException("Invalid merchant. Merchant does not exist");
            }
            throw ex;
        }

        return convert(paymentDao.create(convert(payment)));
    }

    @Override
    public PaymentDtoResponse findById(String s) {
        return null;
    }

    @Override
    public List<PaymentDtoResponse> findAll() {
        return convert(paymentDao.findAll());
    }

    @Override
    public PaymentDtoResponse update(String s, PaymentDtoRequest item) {
        return null;
    }

    @Override
    public void remove(String id) {
        paymentDao.remove(id);
    }

    @Override
    public void remove(PaymentDtoRequest payment) {
        paymentDao.remove(convert(payment));
    }

    @Override
    public void remove() {
        paymentDao.remove();
    }
}
