package com.bolgov.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote extends BaseEntity{

    @Builder
    public Vote(Long id, LocalDateTime date_time, Restaurant restaurant, User user) {
        super(id);
        this.date_time = date_time;
        this.restaurant = restaurant;
        this.user = user;
    }

    private LocalDateTime date_time;
    @ManyToOne(fetch = FetchType.LAZY) //TODO менять на lazy
    @JoinColumn(name = "restaurant_id", nullable = false)
    @Nonnull
    private Restaurant restaurant;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Nonnull
    private User user;
}
