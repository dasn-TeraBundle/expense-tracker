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
}
