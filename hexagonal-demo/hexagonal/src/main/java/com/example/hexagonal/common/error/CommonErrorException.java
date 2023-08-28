package com.example.hexagonal.common.error;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public class CommonErrorException extends RuntimeException {
    protected final CommonErrorCode errorCode;

    public CommonErrorException(String message, CommonErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CommonErrorCode getErrorCode() {
        return errorCode;
    }
}
