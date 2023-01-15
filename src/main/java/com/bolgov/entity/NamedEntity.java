package com.bolgov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {

    //@Size(min = 2, max = 128) Смотреть валидацию в Jakarta
    @Column(name = "name", nullable = false, length = 128)
    protected String name;

}
