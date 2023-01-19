package com.bolgov.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DishDTO {
    private String name;
    private Integer price;
}
