package com.emrekirman.glaceon.user.common.exception.handler;

import com.emrekirman.glaceon.user.common.exception.CustomNotFoundException;
import com.emrekirman.glaceon.user.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.user.common.translator.TranslatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
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
        log.error("Exception invoked. message: {}", e.getMessage(), e);
        return "operation.failed";
    }
}
