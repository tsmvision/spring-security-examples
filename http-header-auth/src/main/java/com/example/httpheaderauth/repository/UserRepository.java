package com.example.httpheaderauth.repository;

import com.example.httpheaderauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom  {
}
