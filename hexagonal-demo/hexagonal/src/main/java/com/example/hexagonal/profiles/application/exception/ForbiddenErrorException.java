package com.example.hexagonal.profiles.application.exception;

import com.example.hexagonal.common.error.CommonErrorCode;
import com.example.hexagonal.common.error.CommonErrorException;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/31
 */
public class ForbiddenErrorException extends CommonErrorException {

    public ForbiddenErrorException() {
        super(CommonErrorCode.FORBIDDEN.name(), CommonErrorCode.FORBIDDEN);
    }
}
