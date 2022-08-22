package com.motyaspr.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private HttpStatus httpStatus;
    private Error error;

    @Data
    @AllArgsConstructor
    public static class Error {
        private String message;
        private String errorClass;
    }


}
