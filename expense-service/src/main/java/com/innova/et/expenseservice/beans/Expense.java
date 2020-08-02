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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (Float.compare(expense.amount, amount) != 0) return false;
        if (id != null ? !id.equals(expense.id) : expense.id != null) return false;
        if (!date.equals(expense.date)) return false;
        if (!category.equals(expense.category)) return false;
        if (!quantity.equals(expense.quantity)) return false;
        return merchant.equals(expense.merchant);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + date.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + quantity.hashCode();
        result = 31 * result + (amount != +0.0f ? Float.floatToIntBits(amount) : 0);
        result = 31 * result + merchant.hashCode();
        return result;
    }
}
