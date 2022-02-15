package com.kryhowsky.allegrotask.controller;

import com.kryhowsky.allegrotask.exceptions.ConnectionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AdviceController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConnectionException.class})
    public void handleConnectionException(ConnectionException connectionException) {
        log.warn("Connection to GitHub impossible.");
    }
}
