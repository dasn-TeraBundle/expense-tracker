package com.innova.et.expenseservice.controller;

import com.innova.et.expenseservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.innova.et.expenseservice.dto.PaymentDto.PaymentDtoRequest;
import static com.innova.et.expenseservice.dto.PaymentDto.PaymentDtoResponse;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public PaymentDtoResponse add(@RequestBody PaymentDtoRequest payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/payment")
    public List<PaymentDtoResponse> list() {
        return paymentService.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        paymentService.remove(id);
    }
}
