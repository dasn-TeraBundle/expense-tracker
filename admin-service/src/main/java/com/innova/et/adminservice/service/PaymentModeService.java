package com.innova.et.adminservice.service;

import com.innova.et.common.service.GenericService;

import static com.innova.et.adminservice.dto.PaymentModeDto.PaymentModeDtoRequest;
import static com.innova.et.adminservice.dto.PaymentModeDto.PaymentModeDtoResponse;

public interface PaymentModeService extends GenericService<PaymentModeDtoRequest, PaymentModeDtoResponse, String> {
}
