package com.example.demo.controller;

import com.example.demo.service.Exercise1Service;
import com.example.demo.service.Exercise2Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    private final Exercise1Service exercise1Service;
    private final Exercise2Service exercise2Service;

    public ApiController(Exercise1Service exercise1Service, Exercise2Service exercise2Service) {
        this.exercise1Service = exercise1Service;
        this.exercise2Service = exercise2Service;
    }

    @GetMapping("/exercise1")
    public String getExercise1(@RequestBody String text) {
        return exercise1Service.getReversedString(text);
    }

    @GetMapping("/exercise2")
    public Integer getExercise2(@RequestBody String text) {
        return exercise2Service.calculate(Integer.parseInt(text));
    }
}
