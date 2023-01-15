package com.bolgov.repository;

import com.bolgov.entity.Dish;
import com.bolgov.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {

}
