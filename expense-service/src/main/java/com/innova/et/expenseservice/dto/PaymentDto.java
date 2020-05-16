package com.innova.et.expenseservice.dto;

import java.util.Date;

public class PaymentDto {

    public static class PaymentDtoRequest {
        private String id;
        private Date date;
        private String merchant;
        private float amount;
        private String paymentMode;
        private String referenceNo;
        private String paymentBy;

    }
}
