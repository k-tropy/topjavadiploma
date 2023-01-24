package com.bolgov.controller;

import com.bolgov.exception.ExceptionsCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
public abstract class BaseController {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleException(RuntimeException e) {
        UUID traceId = UUID.randomUUID();
        log.error(traceId.toString(), e);
        return new ResponseEntity(String.format(ExceptionsCode.SYSTEM_ERROR.getDescription(), traceId),
                HttpStatusCode.valueOf(200));
    }
}
