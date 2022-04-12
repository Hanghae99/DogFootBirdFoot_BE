//package com.hanghae.dogfootbirdfoot_be.service;
//
//import com.hanghae.dogfootbirdfoot_be.model.Likes;
//import com.hanghae.dogfootbirdfoot_be.model.Post;
//import com.hanghae.dogfootbirdfoot_be.repository.LikesRepository;
//import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class LikesService {
//    private final LikesRepository likesRepository;
//    private final UserRepository userRepository;
//    private final PostRepository postRepository;
//
//    //좋아요, 좋아요 취소
//    @Transactional
//    public Likes likes(Long postId, Long userId ){
//        Post postExist = postRepository.findById(postId).orElseThrow(
//                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
//        );
//
//        저장
//        Likes like = likesRepository.findByPostIdAndUserId(postId, userId);
//        if(like==null){
//
//
//        }
//
//
//
//
//    }
//}
