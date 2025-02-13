package org.example.application.controller;

import org.example.application.model.TestDto;
import org.example.application.model.TestDtoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ExampleController {

    @GetMapping
    public ResponseEntity<TestDto> sendTest(@RequestBody TestDtoRequest testDtoRequest) {

        return new ResponseEntity<>(new TestDto("Hello " + testDtoRequest.getName()), HttpStatus.OK);
    }
}
