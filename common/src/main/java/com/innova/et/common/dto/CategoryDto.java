package com.innova.et.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


public class CategoryDto {

    private CategoryDto() { }

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

        public CategoryDtoResponse() {
            this.setSubCategories(new HashSet<>());
        }
    }
}
