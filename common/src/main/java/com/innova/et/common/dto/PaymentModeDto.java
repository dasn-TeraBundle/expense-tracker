package com.innova.et.common.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class PaymentModeDto {

    private PaymentModeDto() { }

    @Getter
    @Setter
    public static class PaymentModeDtoRequest {
        @NotNull
        private String paymentMode;
    }

    public static class PaymentModeDtoResponse extends PaymentModeDtoRequest {
    }
}
