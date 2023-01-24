package com.bolgov.exception;

public enum ExceptionsCode {
    SYSTEM_ERROR ("Произошла системная ошибка. Id: %s"),
    CANT_REVOTE ("После 11:00 нельзя поменять свой выбор"),
    REST_NOT_FOUND("Ресторан не найден"),
    USER_NOT_FOUND("Пользователь не найден"),
    REST_OR_USER_NOT_FOUND("Ресторан с id: %s или пользователь с id: %s не найден");

    private String description;

    ExceptionsCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
