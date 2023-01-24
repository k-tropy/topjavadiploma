package com.bolgov.repository;

import com.bolgov.entity.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface DishRepository extends CrudRepository<Dish, Long> {

    @Query(value = "select d from Dish d left join fetch d.restaurant r\n" +
            "where d.dish_date >= :startDate and d.dish_date <= :endDate")
    List<Dish> findForPeriod(LocalDateTime startDate, LocalDateTime endDate);

    @Transactional
    @Override
    Dish save(Dish dish);
}
