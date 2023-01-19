package com.bolgov.service;

import com.bolgov.entity.Dish;
import com.bolgov.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public final class DishService {

    @Autowired
    private DishRepository repository;

    public List<Dish> findForPeriod(LocalDateTime start, LocalDateTime finish) {
        return repository.findForPeriod(start, finish);
    }

}

