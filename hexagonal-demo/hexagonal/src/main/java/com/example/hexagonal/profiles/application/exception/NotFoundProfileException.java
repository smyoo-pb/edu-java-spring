package com.example.hexagonal.profiles.application.exception;

import com.example.hexagonal.common.error.CommonErrorCode;
import com.example.hexagonal.common.error.CommonErrorException;

/**
 * [description]
 *
 * @author seongminyoo
 * @date 2023/08/28
 */
public class NotFoundProfileException extends CommonErrorException {
    public NotFoundProfileException() {
        super(CommonErrorCode.NOT_FOUND.name(), CommonErrorCode.NOT_FOUND);
    }
}
