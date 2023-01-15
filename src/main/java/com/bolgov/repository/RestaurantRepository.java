package com.bolgov.repository;

import com.bolgov.entity.Restaurant;
import com.bolgov.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
