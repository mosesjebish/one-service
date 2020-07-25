package com.mosesjebish.oneservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/oneservice")
public class OneServiceController {

    @Value("${testmessage}")
    private String message;

    private Logger LOGGER = LoggerFactory.getLogger(OneServiceController.class);

    @GetMapping(value = "/get", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get() {
        LOGGER.info("Message from config server: {}", message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
