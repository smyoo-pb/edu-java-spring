package com.example.hexagonal.infrastructure.security.exception;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
public class NotSupportProviderException extends RuntimeException {
    public NotSupportProviderException(String message) {
        super(message);
    }
}
