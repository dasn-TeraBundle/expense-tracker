package com.innova.et.adminservice.service;

import com.innova.et.common.service.GenericService;

import java.util.List;

import static com.innova.et.common.dto.CategoryDto.CategoryDtoRequest;
import static com.innova.et.common.dto.CategoryDto.CategoryDtoResponse;

public interface CategoryService extends GenericService<CategoryDtoRequest, CategoryDtoResponse, String> {
    CategoryDtoResponse findByName(String name);

    List<CategoryDtoResponse> findAllById_Name();
}
