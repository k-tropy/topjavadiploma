package com.bolgov.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Dish extends NamedEntity{

    @Builder
    public Dish(String name, Integer price, LocalDateTime dish_date, Restaurant restaurant) {
        super(name);
        this.price = price;
        this.dish_date = dish_date;
        this.restaurant = restaurant;
    }

    private Integer price;
    private LocalDateTime dish_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @Nonnull
    private Restaurant restaurant;
}
