package com.hanghae.dogfootbirdfoot_be.repository;

import com.hanghae.dogfootbirdfoot_be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryOrderByModifiedAtDesc(String category);
    List<Post> findByPostTitleContaining(String searchWord);
    //List<Post> findByTitleContainingAndCategory(String searchWord, String catrgory);

}
