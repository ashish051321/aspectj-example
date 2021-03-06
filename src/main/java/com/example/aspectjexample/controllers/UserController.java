package com.example.aspectjexample.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/login/{customerId}")
    @ResponseBody
    public ResponseEntity<String> loginUser(@PathVariable String customerId) {
        log.info("User is logged in");
        return new ResponseEntity("User logged in ", HttpStatus.OK);
    }

    @GetMapping(value = "/logout/{customerId}")
    @ResponseBody
    public ResponseEntity<String> logoutUser(@PathVariable String customerId) {
        log.info("User is logged out");
        return new ResponseEntity("User logged out ", HttpStatus.OK);
    }
}
