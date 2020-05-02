package com.innova.et.adminservice.controller;


import com.innova.et.adminservice.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.innova.et.adminservice.dto.CategoryDto.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "List of categories")
    @GetMapping("/category")
    public List<CategoryDtoResponse> getAll() {
        return convert(categoryService.findAll());
    }

    @ApiOperation(value = "Get category by id")
    @GetMapping("/category/{id}")
    public CategoryDtoResponse getById(@PathVariable String id) {
        return convert(categoryService.findById(id));
    }

    @ApiOperation(value = "Create new category", code = 201)
    @PostMapping("/category")
    @ResponseStatus(value = HttpStatus.CREATED)
    private EntityModel<CategoryDtoResponse> create(@RequestBody @Valid CategoryDtoRequest request) {
        CategoryDtoResponse response = convert(categoryService.create(convert(request)));
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
