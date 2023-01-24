package com.bolgov.controller.admin;

import com.bolgov.DTO.DishAddDTO;
import com.bolgov.entity.Restaurant;
import com.bolgov.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/add")
    public String addRestaurant(@RequestBody DishAddDTO addDTO){
        service.add(addDTO);
        return "Dish " + addDTO.getName() + " was add successfully";
    }
}
