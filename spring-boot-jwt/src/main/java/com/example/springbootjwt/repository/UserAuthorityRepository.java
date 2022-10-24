package com.example.springbootjwt.repository;

import com.example.springbootjwt.entity.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

}
