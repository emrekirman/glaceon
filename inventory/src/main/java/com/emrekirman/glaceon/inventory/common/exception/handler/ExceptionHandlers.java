package com.emrekirman.glaceon.inventory.common.exception.handler;

import com.emrekirman.glaceon.inventory.common.exception.CustomNotFoundException;
import com.emrekirman.glaceon.inventory.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.inventory.common.translator.TranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlers {

    private final TranslatorService translator;

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handle(CustomNotFoundException exception) {
        return translator.translate(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handle(MethodArgumentNotValidException exception) {
        return translator.translate(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(CustomRuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handle(CustomRuntimeException exception) {
        return translator.translate(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handle(Exception e) {
        e.printStackTrace();
        return ("operation.failed");
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handle(HttpClientErrorException e) {
        return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
    }
}
