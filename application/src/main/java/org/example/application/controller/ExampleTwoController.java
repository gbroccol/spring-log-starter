package org.example.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class ExampleTwoController {


    @GetMapping
    public ResponseEntity<String> getTestTwo(@RequestParam String value) {

        return new ResponseEntity<>(value, HttpStatus.CREATED);
    }
}
