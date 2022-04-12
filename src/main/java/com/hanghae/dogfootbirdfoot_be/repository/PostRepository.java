package com.hanghae.dogfootbirdfoot_be.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByUserOrderByCreatedAtDesc(User user, Pageable pageable);
}
