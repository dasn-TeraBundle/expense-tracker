package com.innova.et.expenseservice.service;

import com.innova.et.common.service.GenericService;

import static com.innova.et.expenseservice.dto.PaymentDto.PaymentDtoRequest;
import static com.innova.et.expenseservice.dto.PaymentDto.PaymentDtoResponse;

public interface PaymentService extends GenericService<PaymentDtoRequest, PaymentDtoResponse, String> {
}
