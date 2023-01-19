package com.bolgov.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote extends BaseEntity{

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
