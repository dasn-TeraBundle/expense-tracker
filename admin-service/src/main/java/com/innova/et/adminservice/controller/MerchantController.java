package com.innova.et.adminservice.controller;


import static com.innova.et.adminservice.dto.MerchantDto.*;
import com.innova.et.adminservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MerchantController {

    private final MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/merchant")
    public List<MerchantDtoResponse> findAll() {
        return merchantService.findAll();
    }

    @PostMapping("/merchant")
    public MerchantDtoResponse create(@RequestBody @Valid MerchantDtoRequest request) {
        return merchantService.create(request);
    }
}
