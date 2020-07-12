package com.innova.et.adminservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innova.et.adminservice.beans.Category;
import com.innova.et.adminservice.exception.CategoryNotFoundException;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryDto {

    private CategoryDto() { }

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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter
    @Setter
    public static class CategoryDtoRequest {
        @NotNull
        private String categoryName;
        private Set<String> subCategories;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter
    @Setter
    public static class CategoryDtoResponse extends CategoryDtoRequest {
        private String id;

        CategoryDtoResponse() {
            this.setSubCategories(new HashSet<>());
        }
    }
}
