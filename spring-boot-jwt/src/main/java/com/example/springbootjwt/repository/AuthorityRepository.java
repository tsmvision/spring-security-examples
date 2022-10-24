package com.example.springbootjwt.repository;

import com.example.springbootjwt.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
