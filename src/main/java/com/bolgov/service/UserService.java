package com.bolgov.service;

import com.bolgov.entity.User;
import com.bolgov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public final class UserService {
    @Autowired
    private UserRepository repository;

    public User johnSmith() {
        final User user = new User();
        user.setName("John");
        return user;
    }

    public String findAll() {
        ArrayList<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users.stream().map(User::getName).collect(Collectors.joining(", "));
    }

    public String hello(final User user) {
        return "Hello " + user.getName() + "!";
    }
}

