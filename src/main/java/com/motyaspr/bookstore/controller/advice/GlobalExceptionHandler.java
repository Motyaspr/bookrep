package com.motyaspr.bookstore.controller.advice;

import com.motyaspr.bookstore.dto.ErrorResponse;
import com.motyaspr.bookstore.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> bookNotFound(BookNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND, new ErrorResponse.Error(e.getMessage(), BookNotFoundException.class.getName())), HttpStatus.NOT_FOUND);
    }
}
