package com.hanghae.dogfootbirdfoot_be.repository;

import com.hanghae.dogfootbirdfoot_be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}