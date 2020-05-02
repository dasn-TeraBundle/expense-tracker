package com.innova.et.adminservice.dto;

import com.innova.et.adminservice.beans.PaymentMode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentModeDto {

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

    @Getter
    @Setter
    public static class PaymentModeDtoRequest {
        @NotNull
        private String paymentMode;
    }

    public static class PaymentModeDtoResponse extends PaymentModeDtoRequest {
    }
}
