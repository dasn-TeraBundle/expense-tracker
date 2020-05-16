package com.innova.et.expenseservice.feign;

import static com.innova.et.common.dto.CategoryDto.CategoryDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "admin-service/admin-service")
public interface CategoryClient {

    @GetMapping("/category/{id}")
    CategoryDtoResponse getById(@PathVariable String id);
}
