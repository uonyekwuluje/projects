package com.crudapp.ops;

import com.crudapp.ops.model.Employeerec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;


@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
