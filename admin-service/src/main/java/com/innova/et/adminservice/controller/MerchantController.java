package com.innova.et.adminservice.controller;


import static com.innova.et.adminservice.dto.MerchantDto.*;
import com.innova.et.adminservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MerchantController {

    private final MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/merchant")
    public MerchantDtoResponse create(@RequestBody @Valid MerchantDtoRequest request) {
        return merchantService.create(request);
    }

    @GetMapping("/merchant/{id}")
    public MerchantDtoResponse findById(@PathVariable String id) {
        return merchantService.findById(id);
    }

    @GetMapping("/merchant")
    public List<MerchantDtoResponse> findAll() {
        return merchantService.findAll();
    }


}
