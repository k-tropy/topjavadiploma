package com.bolgov.controller.admin;

import com.bolgov.DTO.RestaurantWithDishesDTO;
import com.bolgov.entity.Restaurant;
import com.bolgov.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/restaurants")
public class AdminRestaurantController {
    private final RestaurantService service;

    @Autowired
    public AdminRestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        service.add(restaurant);
        return "Restaurant " + restaurant.getName() + " was add successfully";
    }

    @GetMapping("/menu_today_test")
    public List<RestaurantWithDishesDTO> menuToday() {
        return service.menuToday();
    }
}
