package com.sentry.logging.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class SharedExceptionHandlingAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(SharedExceptionHandlingAdvice.class);

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> onException(Exception exception) {
        logException(exception);
        return ResponseEntity.internalServerError().build();
    }

    void logException(Exception exception) {
        LOGGER.error("An internal error occurred trackingId: ", exception);
    }

}
