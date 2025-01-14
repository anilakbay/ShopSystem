package com.example.shopsystem.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private String errorType;
    private String message;

    // İsteğe bağlı olarak parametreli constructor eklenebilir
    public ErrorResponse(String errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }
}
