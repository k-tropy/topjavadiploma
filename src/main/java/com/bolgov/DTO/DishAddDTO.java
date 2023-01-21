package com.bolgov.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DishAddDTO {
    private String name;
    private Integer price;
    private Long restaurantId;
}
