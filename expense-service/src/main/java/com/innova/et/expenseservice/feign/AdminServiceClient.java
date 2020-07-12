package com.innova.et.expenseservice.feign;

import com.innova.et.common.dto.MerchantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.innova.et.common.dto.CategoryDto.CategoryDtoResponse;

@FeignClient(name = "admin-service/admin-service")
public interface AdminServiceClient {

    @GetMapping("/category/{id}")
    CategoryDtoResponse getCategoryById(@PathVariable String id);

    @GetMapping("/merchant/{id}")
    MerchantDto.MerchantDtoResponse getMerchantById(@PathVariable String id);

    @GetMapping("/merchant")
    List<MerchantDto.MerchantDtoResponse> getAllMerchant();
}
