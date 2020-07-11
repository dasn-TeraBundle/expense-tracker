package com.innova.et.adminservice.controller;


import com.innova.et.adminservice.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.innova.et.adminservice.dto.CategoryDto.CategoryDtoRequest;
import static com.innova.et.adminservice.dto.CategoryDto.CategoryDtoResponse;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "List of categories")
    @GetMapping("/category")
    public List<CategoryDtoResponse> getAll() {
        return categoryService.findAll();
    }

    @ApiOperation(value = "List of categories with names projection only")
    @GetMapping("/category_name")
    public List<CategoryDtoResponse> getAll_NamesOnly() {
        return categoryService.findAllById_Name();
    }

    @ApiOperation(value = "Get category by id")
    @GetMapping("/category/{id}")
    public CategoryDtoResponse getById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @ApiOperation(value = "Create new category", code = 201)
    @PostMapping("/category")
    @ResponseStatus(value = HttpStatus.CREATED)
    private EntityModel<CategoryDtoResponse> create(@RequestBody @Valid CategoryDtoRequest request) {
        CategoryDtoResponse response = categoryService.create(request);
        var model = new EntityModel<>(response);

        model.add(linkTo(methodOn(CategoryController.class).getById(response.getId())).withRel("get"));
        model.add(linkTo(methodOn(CategoryController.class).getAll()).withRel("all"));

        return model;
    }

    @ApiOperation(value = "Update category")
    @PutMapping("/category/{id}")
    private EntityModel<CategoryDtoResponse> update(@PathVariable String id,
                                                    @RequestBody @Valid CategoryDtoRequest request) {
        CategoryDtoResponse response = categoryService.update(id, request);
        var model = new EntityModel<>(response);

        model.add(linkTo(methodOn(CategoryController.class).getById(response.getId())).withRel("get"));
        model.add(linkTo(methodOn(CategoryController.class).getAll()).withRel("all"));

        return model;
    }

    @DeleteMapping("/category/{id}")
    private void delete(@PathVariable String id) {
        categoryService.remove(id);
    }
}
