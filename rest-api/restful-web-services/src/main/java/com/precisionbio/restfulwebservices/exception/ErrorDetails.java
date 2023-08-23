package com.precisionbio.restfulwebservices.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import jakarta.annotation.Nullable;

public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    @Nullable
    private HashMap<String, List<String>> details;

    public ErrorDetails(LocalDateTime timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = null;
    }

    public ErrorDetails(LocalDateTime timestamp, String message, HashMap<String, List<String>> details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * @return the timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the details
     */
    public HashMap<String, List<String>> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(HashMap<String, List<String>> details) {
        this.details = details;
    }

}
