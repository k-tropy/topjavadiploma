package com.bolgov.repository;

import com.bolgov.entity.Dish;
import com.bolgov.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    @Transactional
    @Override
    Restaurant save(Restaurant restaurant);

}
