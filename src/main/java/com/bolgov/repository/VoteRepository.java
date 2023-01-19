package com.bolgov.repository;

import com.bolgov.entity.Restaurant;
import com.bolgov.entity.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Override
    Optional<Vote> findById(Long aLong);

    @Query(value = "select name from (select restaurant_id\n" +
            "               from vote\n" +
            "               where date_time>= :dateTime\n" +
            "               group by restaurant_id\n" +
            "               having count(id) = (select max(votes) from (select restaurant_id id, count(id) votes\n" +
            "                                                           from vote\n" +
            "                                                           where date_time>= :dateTime\n" +
            "                                                           group by restaurant_id))) t1\n" +
            "left join restaurant t2 on t1.restaurant_id = t2.id;", nativeQuery = true)
    List<String> getWinner(LocalDateTime dateTime);
}
