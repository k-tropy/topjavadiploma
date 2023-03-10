package com.bolgov.repository;

import com.bolgov.entity.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Override
    Optional<Vote> findById(Long aLong);

    @Query(value = "select name from (select restaurant_id\n" +
            "               from vote\n" +
            "               where date_time >= :startDay\n" +
            "               group by restaurant_id\n" +
            "               having count(id) = (select max(votes) from (select restaurant_id id, count(id) votes\n" +
            "                                                           from vote\n" +
            "                                                           where date_time>= :startDay\n" +
            "                                                           group by restaurant_id))) t1\n" +
            "left join restaurant t2 on t1.restaurant_id = t2.id;", nativeQuery = true)
    public List<String> getWinner(LocalDateTime startDay);

    @Query(value = "select v from Vote v where v.user.id = :userId and v.date_time >= :startDay")
    public Optional<Vote> getVoteByUser(Long userId, LocalDateTime startDay);

}
