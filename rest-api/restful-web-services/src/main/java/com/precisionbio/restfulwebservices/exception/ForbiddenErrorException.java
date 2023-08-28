package com.precisionbio.restfulwebservices.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenErrorException extends RuntimeException {
    public ForbiddenErrorException(String message) {
        super(message);
    }
}
