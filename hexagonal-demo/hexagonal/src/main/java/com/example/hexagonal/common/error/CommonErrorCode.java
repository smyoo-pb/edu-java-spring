package com.example.hexagonal.common.error;

import org.springframework.http.HttpStatus;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public enum CommonErrorCode {
    BAD_REQUEST(15, 400),
    FORBIDDEN(16, 403),
    NOT_FOUND(17, 404),
    METHOD_NOT_FOUND(18, 405),
    CONFLICT(19, 409),
    TOO_MANY_REQUEST(20, 429),
    SERVER_ERROR(21, 500),
    QUERY_ERROR(22, 500),
    SERVICE_UNAVAILABLE(23, 503);

    private final int errorCode;
    private final int statusCode;

    CommonErrorCode(int errorCode, int statusCode) {
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.valueOf(statusCode);
    }
}
