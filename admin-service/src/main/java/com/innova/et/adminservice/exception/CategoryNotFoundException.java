package com.innova.et.adminservice.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("Category does not exist");
    }
}
