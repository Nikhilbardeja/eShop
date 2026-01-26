package com.example.eShop.Exception;

import lombok.Data;

@Data
public class ErrorResponse{
    private int statusCode;
    private String message;

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}