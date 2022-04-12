package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.model.Comment;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.model.UserDetailsImpl;
import com.hanghae.dogfootbirdfoot_be.service.CommentService;
import com.hanghae.dogfootbirdfoot_be.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MyPageController {

    private final PostService postService;
    private final CommentService commentService;

    //내가 작성한 게시물 가져오기.
    @GetMapping("/api/mypage/mypost")
    public Page<Post> getMyposts(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.getMypostLists(userDetails.getUser());
    }

//    @GetMapping("/api/mypage/{userId}/mypost")
//    public List<Post> getMyposts(@PathVariable Long userId){
//        return postService.getMyposts(userId);
//    }

    //내가 작성한 댓글 가져오기.
    @GetMapping("/api/mypage/mycomment")
    public Page<Comment> getMyComments(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.getMyComments(userDetails.getUser());
    }

//    @GetMapping("/api/mypage/{userId}/mycomment")
//    public List<Comment> getMyComments(@PathVariable Long userId){
//        return commentService.getMyComments(userId);
//    }
}
