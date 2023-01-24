package com.bolgov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {
    public NamedEntity(Long id) {
        super(id);
    }

    public NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

    public NamedEntity(String name) {
        this.name = name;
    }

    //@Size(min = 2, max = 128) Смотреть валидацию в Jakarta
    @Column(name = "name", nullable = false, length = 128)
    protected String name;

}
