package com.innova.et.adminservice.dto;

import com.innova.et.adminservice.beans.PaymentMode;

import java.util.List;
import java.util.stream.Collectors;

import static com.innova.et.common.dto.PaymentModeDto.PaymentModeDtoRequest;
import static com.innova.et.common.dto.PaymentModeDto.PaymentModeDtoResponse;

public class PaymentModeDto {

    private PaymentModeDto() {
    }

    public static PaymentMode convert(PaymentModeDtoRequest request) {
        return new PaymentMode(request.getPaymentMode());
    }

    public static PaymentModeDtoResponse convert(PaymentMode paymentMode) {
        PaymentModeDtoResponse response = new PaymentModeDtoResponse();
        response.setPaymentMode(paymentMode.getMode());
        return response;
    }

    public static List<PaymentModeDtoResponse> convert(List<PaymentMode> paymentModes) {
        return paymentModes
                .stream()
                .map(PaymentModeDto::convert)
                .collect(Collectors.toList());
    }
}
