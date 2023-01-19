package com.bolgov.service;

import com.bolgov.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public final class VoteService {

    private final LocalDateTime TODAY = LocalDate.now().atStartOfDay();

    private final VoteRepository repository;

    @Autowired
    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public List<String> getWinner() {
        return repository.getWinner(TODAY);
    }

    public String castVote() {
        return null; //todo реализовать - голосование
    }
}

