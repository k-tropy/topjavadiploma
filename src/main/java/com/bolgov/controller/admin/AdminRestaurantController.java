package com.bolgov.controller.admin;

import com.bolgov.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/restaurants")
public class AdminRestaurantController {
    private final RestaurantService service;

    @Autowired
    public AdminRestaurantController(RestaurantService service) {
        this.service = service;
    }

    //TODO реализовать добавление ресторана POST
}
