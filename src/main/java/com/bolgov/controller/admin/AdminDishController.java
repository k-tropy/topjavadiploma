package com.bolgov.controller.admin;

import com.bolgov.DTO.DishAddDTO;
import com.bolgov.controller.BaseController;
import com.bolgov.exception.NotFoundException;
import com.bolgov.service.DishService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/dishes")
public class AdminDishController extends BaseController {
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

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleException(NotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatusCode.valueOf(200));
    }
}
