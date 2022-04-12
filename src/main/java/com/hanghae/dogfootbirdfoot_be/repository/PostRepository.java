package com.hanghae.dogfootbirdfoot_be.repository;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByUserOrderByCreatedAtDesc(User user, Pageable pageable);
=======
import com.hanghae.dogfootbirdfoot_be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryOrderByModifiedAtDesc(String category);
    Optional<Post> findById(Long Id);

    @Query(value = "SELECT b FROM Post b WHERE b.postTitle LIKE %:searchWord% OR b.postContents LIKE %:searchWord% ORDER BY b.modifiedAt DESC")
    List<Post> findAllSearch(String searchWord);


// "SELECT b FROM Post b WHERE b.postTitle LIKE %:searchWord% OR b.postContents LIKE %:searchWord%"


    //("SELECT p FROM Article p ORDER BY p.id DESC")
>>>>>>> origin/master
}
