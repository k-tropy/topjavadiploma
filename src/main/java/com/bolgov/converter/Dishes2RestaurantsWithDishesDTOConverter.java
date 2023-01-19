package com.bolgov.converter;

import com.bolgov.DTO.DishDTO;
import com.bolgov.DTO.RestaurantWithDishesDTO;
import com.bolgov.entity.Dish;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Dishes2RestaurantsWithDishesDTOConverter implements Converter<List<Dish>, List<RestaurantWithDishesDTO>> {

    @Override
    public List<RestaurantWithDishesDTO> convert(List<Dish> source) {
        HashMap<Long, List<Dish>> map = new HashMap<>();
        source.forEach(dish -> {
            Long key = dish.getRestaurant().getId();
            if (map.containsKey(key)) {
                map.get(key).add(dish);
            } else {
                map.put(key, new ArrayList<>(List.of(dish)));
            }
        });
        return map.values().stream()
                .map(l -> RestaurantWithDishesDTO.builder()
                        .id(l.get(0).getRestaurant().getId())
                        .name(l.get(0).getRestaurant().getName())
                        .dishes(l.stream()
                                .map(d -> DishDTO.builder().price(d.getPrice()).name(d.getName()).build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }
}
