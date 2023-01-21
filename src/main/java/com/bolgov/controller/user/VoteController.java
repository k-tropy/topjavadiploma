package com.bolgov.controller.user;

import com.bolgov.entity.Vote;
import com.bolgov.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/votes")
public class VoteController {
    private final VoteService service;

    @Autowired
    public VoteController(VoteService service) {
        this.service = service;
    }

    @GetMapping("/winner")
    public List<String> winner() {
        return service.getWinner();
    }

    @GetMapping("/vote")
    public Vote castVote(@RequestParam Long userId, @RequestParam Long restaurantId) {
        return service.castVote(userId, restaurantId);
    }

}
