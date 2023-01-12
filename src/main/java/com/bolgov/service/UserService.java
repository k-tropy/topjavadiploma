package com.bolgov.service;

import com.bolgov.User;
import org.springframework.stereotype.Service;

@Service
public final class UserService {

    public User johnSmith() {
        final User user = new User();
        user.setFirstname("John");
        user.setLastname("Smith");
        return user;
    }

    public String hello(final User user) {
        return "Hello " + user.getFirstname() + " " + user.getLastname() + "!";
    }
}

