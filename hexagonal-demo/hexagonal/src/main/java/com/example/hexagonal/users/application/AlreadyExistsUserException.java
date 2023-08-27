package com.example.hexagonal.users.application;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
public class AlreadyExistsUserException extends RuntimeException {
    public AlreadyExistsUserException(String message) {
        super(message);
    }
}
