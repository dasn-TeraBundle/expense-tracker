package com.innova.et.expenseservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innova.et.expenseservice.beans.Payment;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentDto {

    private PaymentDto() { }

    public static Payment convert(PaymentDtoRequest req) {
        var payment = new Payment();
        payment.setDate(req.getPaymentDate());
        payment.setMerchant(req.getMerchant());
        payment.setAmount(req.getAmount());
        payment.setPaymentMode(req.getPaymentMode());
        payment.setReferenceNo(req.getReferenceNo());
        payment.setPaymentBy(req.getPaymentBy());

        return payment;
    }

    public static PaymentDtoResponse convert(Payment payment) {
        var resp = new PaymentDtoResponse();
        resp.setPaymentId(payment.getId());
        resp.setPaymentDate(payment.getDate());
        resp.setMerchant(payment.getMerchant());
        resp.setAmount(payment.getAmount());
        resp.setPaymentMode(payment.getPaymentMode());
        resp.setReferenceNo(payment.getReferenceNo());
        resp.setPaymentBy(payment.getPaymentBy());

        return resp;
    }

    public static List<PaymentDtoResponse> convert(List<Payment> payments) {
        return payments
                .stream()
                .map(PaymentDto::convert)
                .collect(Collectors.toList());
    }

    @Getter
    @Setter
    public static class PaymentDtoRequest {
        private Date paymentDate;
        @NotNull
        private String merchant;
        @NotNull
        private float amount;
        @NotNull
        private String paymentMode;
        private String referenceNo;
        @NotNull
        private String paymentBy;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PaymentDtoResponse extends PaymentDtoRequest {
        private String paymentId;
    }
}
