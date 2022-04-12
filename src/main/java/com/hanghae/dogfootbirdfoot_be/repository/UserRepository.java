package com.hanghae.dogfootbirdfoot_be.repository;

import com.hanghae.dogfootbirdfoot_be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
