package com.learning.demo.springbootcrudhibernate.crudapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping
    public String home() {
        return "Hello World";
    }

}
