package com.bolgov.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Restaurant extends NamedEntity{

    @Builder
    public Restaurant(String name) {
        super(name);
    }

}
