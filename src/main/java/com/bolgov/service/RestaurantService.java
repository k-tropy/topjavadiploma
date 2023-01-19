package com.bolgov.service;

import com.bolgov.DTO.RestaurantWithDishesDTO;
import com.bolgov.converter.Dishes2RestaurantsWithDishesDTOConverter;
import com.bolgov.entity.Dish;
import com.bolgov.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public final class RestaurantService {

    private final LocalDateTime START_TODAY = LocalDate.now().atStartOfDay();
    private final LocalDateTime NOW = LocalDateTime.now();

    private final RestaurantRepository repository;
    private final DishService dishService;
    private final Dishes2RestaurantsWithDishesDTOConverter converter;

    @Autowired
    public RestaurantService(RestaurantRepository repository, DishService dishService, Dishes2RestaurantsWithDishesDTOConverter converter) {
        this.repository = repository;
        this.dishService = dishService;
        this.converter = converter;
    }

    public List<RestaurantWithDishesDTO> menuToday() {
        List<Dish> dishes = dishService.findForPeriod(START_TODAY, NOW);
        return converter.convert(dishes);
    }



}

