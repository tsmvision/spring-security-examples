package com.example.springbootjwt.repository;

import com.example.springbootjwt.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<Long> findById(long id);
//    Optional<User> findByEmail(String username);
    Optional<User> findByUsername(String username);
}
