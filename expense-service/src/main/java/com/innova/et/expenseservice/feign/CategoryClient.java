package com.innova.et.expenseservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.innova.et.common.dto.CategoryDto.CategoryDtoResponse;

@FeignClient(name = "admin-service/admin-service")
public interface CategoryClient {

    @GetMapping("/category/{id}")
    CategoryDtoResponse getById(@PathVariable String id);
}
