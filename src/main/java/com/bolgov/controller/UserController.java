package com.bolgov.controller;

import com.bolgov.entity.User;
import com.bolgov.service.UserService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/user")
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserController {
    private final UserService service;

    @GetMapping("/johnsmith")
    public User hello() {
return  service.johnSmith();
    }

    @GetMapping("/all")
    public String all() {
        return  service.findAll();
    }

    @PostMapping("/hello")
    public String postHello(@RequestBody final User user) {
        return service.hello(user);
    }
}