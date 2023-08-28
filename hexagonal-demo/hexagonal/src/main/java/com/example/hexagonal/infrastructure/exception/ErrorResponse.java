package com.example.hexagonal.infrastructure.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String error;
    private String message;
    @Nullable
    private HashMap<String, List<String>> details;

    public ErrorResponse(LocalDateTime timestamp, String error, String message) {
        this.timestamp = timestamp;
        this.error = error;
        this.message = message;
        this.details = null;
    }

    public ErrorResponse(LocalDateTime timestamp, String error, String message, HashMap<String, List<String>> details) {
        this.timestamp = timestamp;
        this.error = error;
        this.message = message;
        this.details = details;
    }
}
