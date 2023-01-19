package com.bolgov.service;

import com.bolgov.entity.Restaurant;
import com.bolgov.entity.User;
import com.bolgov.entity.Vote;
import com.bolgov.repository.UserRepository;
import com.bolgov.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class VoteService {

    private final LocalDateTime TODAY = LocalDate.now().atStartOfDay();
    @Autowired
    private VoteRepository repository;

    public User johnSmith() {
        final User user = new User();
        user.setName("John");
        return user;
    }

    public List<Vote> findAll() {
        return (ArrayList) repository.findAll();
    }

    public Vote getById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<String> getWinner() {
        return repository.getWinner(TODAY);
    }
}

