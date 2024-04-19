package com.work.pennyflo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.pennyflo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

