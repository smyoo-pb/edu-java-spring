package com.example.hexagonal.profiles.application.exception;

import com.example.hexagonal.common.error.CommonErrorCode;
import com.example.hexagonal.common.error.CommonErrorException;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
public class AlreadyExistsProfileException extends CommonErrorException {
    public AlreadyExistsProfileException() {
        super(CommonErrorCode.CONFLICT.name(), CommonErrorCode.CONFLICT);
    }
}
