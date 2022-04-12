package com.hanghae.dogfootbirdfoot_be.repository;

import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByUserOrderByCreatedAtDesc(User user, Pageable pageable);
    List<Post> findByCategoryOrderByModifiedAtDesc(String category);
    Optional<Post> findById(Long Id);

    @Query(value = "SELECT b FROM Post b WHERE b.postTitle LIKE %:searchWord% OR b.postContents LIKE %:searchWord% ORDER BY b.modifiedAt DESC")
    List<Post> findAllSearch(String searchWord);


}
