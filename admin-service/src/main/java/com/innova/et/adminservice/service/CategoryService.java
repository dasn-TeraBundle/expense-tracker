package com.innova.et.adminservice.service;

import com.innova.et.common.service.GenericService;

import static com.innova.et.adminservice.dto.CategoryDto.CategoryDtoRequest;
import static com.innova.et.adminservice.dto.CategoryDto.CategoryDtoResponse;

public interface CategoryService extends GenericService<CategoryDtoRequest, CategoryDtoResponse, String> {
    CategoryDtoResponse findByName(String name);
}
