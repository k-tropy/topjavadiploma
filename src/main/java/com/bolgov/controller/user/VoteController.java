package com.bolgov.controller.user;

import com.bolgov.controller.BaseController;
import com.bolgov.entity.Vote;
import com.bolgov.exception.NotFoundException;
import com.bolgov.exception.OwnException;
import com.bolgov.exception.VoteException;
import com.bolgov.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user/votes")
public class VoteController extends BaseController {
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

    @ExceptionHandler({VoteException.class, NotFoundException.class})
    public ResponseEntity handleException(OwnException e) {
        return new ResponseEntity(e.getMessage(), HttpStatusCode.valueOf(200));
    }

}
