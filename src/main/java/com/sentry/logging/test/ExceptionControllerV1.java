package com.sentry.logging.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/v1/exception/trigger")
public class ExceptionControllerV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerV1.class);

    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> triggerException() {
        LOGGER.trace("trace message");
        LOGGER.info("info message");
        LOGGER.debug("debug message");
        throw new IllegalStateException("uncaught error");
    }
}
