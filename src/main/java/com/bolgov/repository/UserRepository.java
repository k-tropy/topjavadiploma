package com.bolgov.repository;

import com.bolgov.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<User, Long> {
        public User findByName(String name);
}
