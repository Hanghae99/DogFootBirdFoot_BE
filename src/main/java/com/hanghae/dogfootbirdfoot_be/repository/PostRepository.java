package com.hanghae.dogfootbirdfoot_be.repository;

import com.hanghae.dogfootbirdfoot_be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryOrderByModifiedAtDesc(String category);
    //List<Post> findByPostTitleContaining(String searchWord);
    Optional<Post> findById(Long Id);

    @Query(value = "SELECT b FROM Post b WHERE b.postTitle LIKE %:searchWord%")
    List<Post> findAllSearch(String searchWord);



}
