package com.bolgov.service;

import com.bolgov.DTO.RestaurantWithDishesDTO;
import com.bolgov.entity.Dish;
import com.bolgov.entity.Restaurant;
import com.bolgov.repository.DishRepository;
import com.bolgov.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public final class RestaurantService {

    private final LocalDateTime START_TODAY = LocalDate.now().atStartOfDay();
    private final LocalDateTime NOW = LocalDateTime.now();

    private final RestaurantRepository repository;
    private final DishRepository dishRepository;
    private ConversionService conversionService;

    @Autowired
    public RestaurantService(RestaurantRepository repository, DishRepository dishRepository, ConversionService conversionService) {
        this.repository = repository;
        this.dishRepository = dishRepository;
        this.conversionService = conversionService;
    }

    public List<RestaurantWithDishesDTO> menuToday() {
        List<Dish> dishes = dishRepository.findForPeriod(START_TODAY, NOW);
        return conversionService.convert(dishes, List.class);
    }

    public void add(Restaurant restaurant) {
        repository.save(restaurant);
    }

    public Iterable<Restaurant> findAll() {
        return repository.findAll();
    }
}
