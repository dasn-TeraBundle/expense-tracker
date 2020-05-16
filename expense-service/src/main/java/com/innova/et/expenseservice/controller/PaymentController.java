package com.innova.et.expenseservice.controller;

import com.innova.et.expenseservice.beans.Payment;
import com.innova.et.expenseservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public Payment add(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/payment")
    public List<Payment> list() {
        return paymentService.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id) {
        paymentService.remove(id);
    }
}
