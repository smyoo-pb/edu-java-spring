package com.example.hexagonal.infrastructure.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
import com.example.hexagonal.users.application.exceptions.AlreadyExistsUserException;
import com.example.hexagonal.users.application.exceptions.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    private final String translateMessage(String messageCode, Object... args) {
        return messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }

    private final String translateMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
    }

    /**
     * Handles the exception of type Exception and returns a ResponseEntity
     * 
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllException(Exception ex, WebRequest request) {
        var errorCode = CommonErrorCode.SERVER_ERROR;
        log.error(ex.toString());
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                errorCode.name(),
                ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorDetails, errorCode.getHttpStatus());
    }

    /**
     * Handles the exception of type CommonErrorException and returns a
     * ResponseEntity
     * with an ErrorResponse object containing the error details.
     *
     * @param ex      the CommonErrorException object representing the exception
     * @param request the WebRequest object representing the HTTP request
     * @return a ResponseEntity object containing the error details
     */
    @ExceptionHandler(CommonErrorException.class)
    public final ResponseEntity<ErrorResponse> handleApiException(CommonErrorException ex, WebRequest request) {
        var errorCode = ex.getErrorCode();
        log.debug(ex.toString());
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                errorCode.name(),
                ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorDetails, errorCode.getHttpStatus());
    }

    /**
     * Handles a MethodArgumentNotValidException for validating method arguments.
     *
     * @param ex      the MethodArgumentNotValidException object
     * @param headers the HttpHeaders object
     * @param status  the HttpStatusCode object
     * @param request the WebRequest object
     * @return the ResponseEntity<Object> object
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        HashMap<String, List<String>> details = new HashMap<>();

        for (FieldError error : ex.getFieldErrors()) {
            log.debug(error.toString());

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

    @ExceptionHandler(NotFoundUserException.class)
    public final ResponseEntity<ErrorResponse> handleNotFoundUserException(NotFoundUserException ex,
            WebRequest request) {
        var errorCode = CommonErrorCode.NOT_FOUND;
        log.debug(ex.toString());

        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                errorCode.name(),
                translateMessage("users.read.notFound"));
        return new ResponseEntity<ErrorResponse>(errorDetails, errorCode.getHttpStatus());
    }

    @ExceptionHandler(AlreadyExistsUserException.class)
    public final ResponseEntity<ErrorResponse> handleAlreadyExistsUserException(AlreadyExistsUserException ex,
            WebRequest request) {
        var errorCode = CommonErrorCode.CONFLICT;
        log.debug(ex.toString());
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                errorCode.name(),
                translateMessage("users.create.exists"));
        return new ResponseEntity<ErrorResponse>(errorDetails, errorCode.getHttpStatus());
    }
}
