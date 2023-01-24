package com.bolgov.service;

import com.bolgov.DTO.DishAddDTO;
import com.bolgov.entity.Dish;
import com.bolgov.entity.Restaurant;
import com.bolgov.entity.User;
import com.bolgov.exception.ExceptionsCode;
import com.bolgov.repository.DishRepository;
import com.bolgov.repository.RestaurantRepository;
import com.bolgov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public final class UserService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(ExceptionsCode.USER_NOT_FOUND.getDescription());
        }
        return user;
    }
}
