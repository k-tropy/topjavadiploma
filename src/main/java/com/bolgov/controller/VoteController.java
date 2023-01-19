package com.bolgov.controller;

import com.bolgov.entity.Restaurant;
import com.bolgov.entity.User;
import com.bolgov.entity.Vote;
import com.bolgov.service.UserService;
import com.bolgov.service.VoteService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/vote")
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class VoteController {
    private final VoteService service;

    @GetMapping("/winner")
    public List<String> winner() {
        //return  service.findAll();
        return service.getWinner();
    }

    @GetMapping("/getbyid")
    public Vote winner(@RequestParam Long id) {
        //return  service.findAll();
        return service.getById(id);
    }

    @GetMapping("/getall")
    public List<Vote> getAll() {
        return service.findAll();
    }

    @GetMapping("/give_vote")
    public void give_vote() {
    }
}
