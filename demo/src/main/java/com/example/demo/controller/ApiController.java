package com.example.demo.controller;

import com.example.demo.service.SomeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    private final SomeService someService;

    public ApiController(SomeService someService) {
        this.someService = someService;
    }

    @GetMapping("/exercise1")
    public String getExercise1(@RequestBody String text) {
        return someService.getReversedString(text);
    }
}
