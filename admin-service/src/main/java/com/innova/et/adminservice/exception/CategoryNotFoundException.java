package com.innova.et.adminservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("Category does not exist");
    }
}
