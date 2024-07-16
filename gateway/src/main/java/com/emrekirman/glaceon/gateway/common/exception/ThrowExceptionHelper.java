package com.emrekirman.glaceon.gateway.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ThrowExceptionHelper<T> {

    public void checkException(ResponseEntity<T> responseEntity) {
        HttpStatusCode statusCode = responseEntity.getStatusCode();

        if (statusCode.equals(HttpStatus.BAD_REQUEST)) {
            throw new CustomRuntimeException(responseEntity.getBody().toString());
        }

        if (statusCode.equals(HttpStatus.NOT_FOUND)) {
            throw new CustomNotFoundException(responseEntity.getBody().toString());
        }
    }
}
