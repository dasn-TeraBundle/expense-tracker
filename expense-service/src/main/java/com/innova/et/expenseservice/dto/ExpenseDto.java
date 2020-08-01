package com.innova.et.expenseservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.innova.et.expenseservice.beans.Expense;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDto {

    private ExpenseDto() { }

    public static Expense convert(ExpenseDtoRequest req) {
        var expense = new Expense(req.getPurchaseDate(), req.getCategory(),
                req.getQuantity(), req.getAmount(), req.getMerchant());
        expense.setSubCategory(req.getSubCategory());
        return expense;
    }

    public static ExpenseDtoResponse convert(Expense exp) {
        var resp = new ExpenseDtoResponse();
        resp.setExpenseId(exp.getId());
        resp.setPurchaseDate(exp.getDate());
        resp.setCategory(exp.getCategory());
        resp.setSubCategory(exp.getSubCategory());
        resp.setQuantity(exp.getQuantity());
        resp.setAmount(exp.getAmount());
        resp.setMerchant(exp.getMerchant());

        return resp;
    }

    public static List<ExpenseDtoResponse> convert(List<Expense> exps) {
        return exps
                .stream()
                .map(ExpenseDto::convert)
                .collect(Collectors.toList());
    }

    @Getter
    @Setter
    public static class ExpenseDtoRequest {
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date purchaseDate;
        @NotNull
        private String category;
        private String subCategory;
        @NotNull
        private String quantity;
        @NotNull
        private float amount;
        @NotNull
        private String merchant;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ExpenseDtoResponse {
        private String expenseId;
        private Date purchaseDate;
        private String category;
        private String subCategory;
        private String quantity;
        private float amount;
        private String merchant;
    }
}
