package com.bolgov.controller.admin;

import com.bolgov.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/dishes")
public class AdminDishController {
    private final DishService service;

    @Autowired
    public AdminDishController(DishService service) {
        this.service = service;
    }

    //TODO реализовать добавление блюда POST
}
