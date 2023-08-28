package com.example.hexagonal.users.application.exceptions;

import com.example.hexagonal.common.error.CommonErrorCode;
import com.example.hexagonal.common.error.CommonErrorException;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
public class AlreadyExistsUserException extends CommonErrorException {
    public AlreadyExistsUserException(String message) {
        super(message, CommonErrorCode.CONFLICT);
    }
}
