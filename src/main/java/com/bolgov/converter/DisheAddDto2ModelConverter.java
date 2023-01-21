package com.bolgov.converter;

import com.bolgov.DTO.DishAddDTO;
import com.bolgov.entity.Dish;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

@NoArgsConstructor
public class DisheAddDto2ModelConverter implements Converter<DishAddDTO, Dish> {

    @Override
    public Dish convert(DishAddDTO source) {
        return Dish.builder()
                .dish_date(LocalDateTime.now())
                .price(source.getPrice())
                .name(source.getName())
                .build();
    }
}
