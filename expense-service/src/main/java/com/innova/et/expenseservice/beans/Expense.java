package com.innova.et.expenseservice.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "expenses")
public class Expense implements Serializable {

    @Id
    private String id;
    private Date date;
    private String category;
    private String subCategory;
    private String quantity;
    private float amount;
    private String merchant;

    public Expense(Date date, String category, String quantity, float amount, String merchant) {
        this.date = date;
        this.category = category;
        this.quantity = quantity;
        this.amount = amount;
        this.merchant = merchant;
    }

}
