package com.yarkin.careerguidance.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/exams")
public class ExamController {
    @GetMapping
    public String findAll() {
        return "All works!";
    }
}
