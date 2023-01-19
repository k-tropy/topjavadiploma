package com.bolgov.DTO;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class RestaurantWithDishesDTO {

    private Long id;
    private String name;
    private List<DishDTO> dishes;
}
