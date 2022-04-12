//package com.hanghae.dogfootbirdfoot_be.repository;
//
//import com.hanghae.dogfootbirdfoot_be.model.Likes;
//import com.hanghae.dogfootbirdfoot_be.model.Post;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface LikesRepository extends JpaRepository<Likes, Long> {
//    Optional<Likes> findByPostId(Long postId);
//    Likes findByPostIdAndUserId(Long postId, Long userId);
//}
