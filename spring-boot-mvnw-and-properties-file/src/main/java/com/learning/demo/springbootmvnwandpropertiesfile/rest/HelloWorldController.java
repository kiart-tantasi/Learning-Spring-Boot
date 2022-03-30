package com.learning.demo.springbootmvnwandpropertiesfile.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorldController {

    @GetMapping
    public String home() {
        return "1. 'mvnw package' to build .jar;" +
                "\n2. 'cd target' and 'java -jar file.jar' to run .jar file;" +
                "\n3. 'mvnw spring-boot:run' to start server without using .jar file";
    }

    @GetMapping("/helloworld")
    public String get() {
        return "Hello World " + LocalDateTime.now();
    }

}
