package com.bolgov.service;

import com.bolgov.entity.Restaurant;
import com.bolgov.entity.User;
import com.bolgov.entity.Vote;
import com.bolgov.repository.RestaurantRepository;
import com.bolgov.repository.UserRepository;
import com.bolgov.repository.VoteRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public final class VoteService {

    private final LocalDateTime START_OF_TODAY = LocalDate.now().atStartOfDay();

    private final VoteRepository repository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;


    @Autowired
    public VoteService(VoteRepository repository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<String> getWinner() {
        return repository.getWinner(START_OF_TODAY);
    }

    public Vote castVote(Long userId, Long restaurantId) {
        Optional<Vote> voteByUser = repository.getVoteByUser(userId, START_OF_TODAY);
        return voteByUser.map(v -> updateOrThrow(v, restaurantId))
                .orElseGet(() -> saveIfPossible(userId, restaurantId));
    }

    private Vote saveIfPossible(Long userId, Long restaurantId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (user.isPresent() && restaurant.isPresent()) {
            return repository.save(Vote.builder()
                    .restaurant(restaurant.get())
                    .user(user.get())
                    .date_time(LocalDateTime.now())
                    .build());
        } else {
            log.warn("Restaurant with id: %s or user with id: %s were not found");
            throw new RuntimeException("Пользователь или ресторан не существует");
        }
    }

    private Vote updateOrThrow(Vote vote, Long restaurantId) {
        if (isUpdatePossible()) {
            vote.setRestaurant(restaurantRepository.findById(restaurantId).get());
            return repository.save(vote);
        } else {
            throw new RuntimeException("После 11:00 нельзя поменять свой выбор");
        }
    }

    private boolean isUpdatePossible() {
        return LocalTime.now().isBefore(LocalTime.of(11, 0));
    }


}

