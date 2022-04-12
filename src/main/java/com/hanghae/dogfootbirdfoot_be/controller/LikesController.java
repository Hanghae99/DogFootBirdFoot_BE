//package com.hanghae.dogfootbirdfoot_be.controller;
//
//
//import com.hanghae.dogfootbirdfoot_be.model.Likes;
//import com.hanghae.dogfootbirdfoot_be.repository.LikesRepository;
//import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
//import com.hanghae.dogfootbirdfoot_be.service.LikesService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class LikesController {
//    private final LikesRepository likesRepository;
//    private final LikesService likesService;
//
//    @PostMapping("/api/{postId}/likes")
//    public Likes up(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        Long userId = userDetails.getUser().getId();
//        likesService.likes(postId, userId);
//
//    }
//
//
//}
