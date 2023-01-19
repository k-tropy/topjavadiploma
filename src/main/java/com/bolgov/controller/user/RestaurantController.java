package com.bolgov.controller.user;

import com.bolgov.DTO.RestaurantWithDishesDTO;
import com.bolgov.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/restaurants")
public class RestaurantController {
    private final RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("/menu_today")
    public List<RestaurantWithDishesDTO> menuToday() {
        return service.menuToday();
    }

}
