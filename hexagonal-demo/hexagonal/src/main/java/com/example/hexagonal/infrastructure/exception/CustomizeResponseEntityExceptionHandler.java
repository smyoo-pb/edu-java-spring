package com.example.hexagonal.infrastructure.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.hexagonal.common.error.CommonErrorCode;
import com.example.hexagonal.common.error.CommonErrorException;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomizeResponseEntityExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllException(Exception ex, WebRequest request) {
        var errorCode = CommonErrorCode.SERVER_ERROR;
        LOGGER.error(ex.getMessage());
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                errorCode.name(),
                ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorDetails, errorCode.getHttpStatus());
    }

    @ExceptionHandler(CommonErrorException.class)
    public final ResponseEntity<ErrorResponse> handleApiException(CommonErrorException ex, WebRequest request) {
        var errorCode = ex.getErrorCode();

        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                errorCode.name(),
                ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorDetails, errorCode.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        HashMap<String, List<String>> details = new HashMap<>();
        for (FieldError error : ex.getFieldErrors()) {
            LOGGER.debug(error.toString());
            List<String> errorMessages = new ArrayList<>();
            if (details.containsKey(error.getField())) {
                errorMessages = details.get(error.getField());
            }
            errorMessages.add(error.getDefaultMessage());
            details.put(error.getField(), errorMessages);
        }

        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                CommonErrorCode.BAD_REQUEST.name(),
                "Validation Failed",
                details);
        return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
