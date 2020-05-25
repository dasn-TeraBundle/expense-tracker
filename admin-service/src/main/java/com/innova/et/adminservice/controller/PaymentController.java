package com.innova.et.adminservice.controller;


import com.innova.et.adminservice.dto.PaymentModeDto;
import com.innova.et.adminservice.service.PaymentModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.innova.et.adminservice.dto.PaymentModeDto.PaymentModeDtoResponse;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PaymentController {

    private PaymentModeService paymentModeService;

    @Autowired
    public PaymentController(PaymentModeService paymentModeService) {
        this.paymentModeService = paymentModeService;
    }

    @GetMapping("/payment")
    public List<PaymentModeDtoResponse> findAll() {
        return paymentModeService.findAll();
    }

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<PaymentModeDtoResponse> create(@RequestBody @Valid PaymentModeDto.PaymentModeDtoRequest request) {
        PaymentModeDtoResponse response = paymentModeService.create(request);
        var model = new EntityModel<>(response);

        model.add(linkTo(methodOn(PaymentController.class).findAll()).withRel("all"));

        return model;
    }

}
