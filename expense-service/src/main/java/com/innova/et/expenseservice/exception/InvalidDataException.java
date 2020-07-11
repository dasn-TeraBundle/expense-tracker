package com.innova.et.expenseservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataException extends IllegalArgumentException {

    public InvalidDataException(String s) {
        super(s);
    }
}
