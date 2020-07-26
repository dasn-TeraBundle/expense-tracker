package com.innova.et.adminservice.dto;

import com.innova.et.adminservice.beans.Category;
import com.innova.et.adminservice.exception.CategoryNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static com.innova.et.common.dto.CategoryDto.CategoryDtoRequest;
import static com.innova.et.common.dto.CategoryDto.CategoryDtoResponse;

public class CategoryDto {

    private CategoryDto() {
    }

    public static Category convert(CategoryDtoRequest request) {
        var category = new Category(request.getCategoryName());
        category.setChildren(request.getSubCategories());
        return category;
    }

    public static CategoryDtoResponse convert(Category category) {
        if (category == null)
            throw new CategoryNotFoundException();
        var categoryResponse = new CategoryDtoResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setCategoryName(category.getName());
        categoryResponse.setSubCategories(category.getChildren());
        return categoryResponse;
    }

    public static List<CategoryDtoResponse> convert(List<Category> categories) {
        return categories
                .stream()
                .map(CategoryDto::convert)
                .collect(Collectors.toList());
    }

}
