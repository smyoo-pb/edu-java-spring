package com.example.hexagonal.users.application.exceptions;

import com.example.hexagonal.common.error.CommonErrorCode;
import com.example.hexagonal.common.error.CommonErrorException;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public class NotFoundUserException extends CommonErrorException {
    public NotFoundUserException(String message) {
        super(message, CommonErrorCode.NOT_FOUND);
    }
}
