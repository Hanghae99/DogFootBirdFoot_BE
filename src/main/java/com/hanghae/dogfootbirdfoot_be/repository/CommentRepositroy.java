package com.hanghae.dogfootbirdfoot_be.repository;


import com.hanghae.dogfootbirdfoot_be.model.Comment;

import com.hanghae.dogfootbirdfoot_be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepositroy extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Post post);

}
