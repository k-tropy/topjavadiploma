package com.bolgov.service;

import com.bolgov.DTO.DishAddDTO;
import com.bolgov.entity.Dish;
import com.bolgov.entity.Restaurant;
import com.bolgov.repository.DishRepository;
import com.bolgov.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public final class DishService {

    private DishRepository repository;
    private ConversionService conversionService;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public DishService(DishRepository repository, ConversionService conversionService, RestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Dish> findForPeriod(LocalDateTime start, LocalDateTime finish) {
        return repository.findForPeriod(start, finish);
    }

    public void add(DishAddDTO addDTO) {
        Dish dish = conversionService.convert(addDTO, Dish.class);
        Restaurant restaurant = restaurantRepository.findById(addDTO.getRestaurantId()).orElseThrow();//TODO сделать свои исключения
        dish.setRestaurant(restaurant);
        repository.save(dish);//throw new IllegalArgumentException(message);
    }
}
