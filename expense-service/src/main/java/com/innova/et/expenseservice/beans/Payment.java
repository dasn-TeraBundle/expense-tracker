package com.innova.et.expenseservice.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "payments")
public class Payment implements Serializable {

    private String id;
    private Date date;
    private String merchant;
    private float amount;
    private String paymentMode;
    private String referenceNo;
    private String paymentBy;

    public Payment(Date date, String merchant, float amount, String paymentMode, String paymentBy) {
        this.date = date;
        this.merchant = merchant;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paymentBy = paymentBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (Float.compare(payment.amount, amount) != 0) return false;
        if (id != null ? !id.equals(payment.id) : payment.id != null) return false;
        if (!date.equals(payment.date)) return false;
        if (!merchant.equals(payment.merchant)) return false;
        if (!paymentMode.equals(payment.paymentMode)) return false;
        if (referenceNo != null ? !referenceNo.equals(payment.referenceNo) : payment.referenceNo != null) return false;
        return paymentBy.equals(payment.paymentBy);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + date.hashCode();
        result = 31 * result + merchant.hashCode();
        result = 31 * result + (amount != +0.0f ? Float.floatToIntBits(amount) : 0);
        result = 31 * result + paymentMode.hashCode();
        result = 31 * result + (referenceNo != null ? referenceNo.hashCode() : 0);
        result = 31 * result + paymentBy.hashCode();
        return result;
    }
}
