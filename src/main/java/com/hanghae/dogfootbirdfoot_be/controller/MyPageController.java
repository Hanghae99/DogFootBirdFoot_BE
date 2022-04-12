package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.dto.UserInfoDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import com.hanghae.dogfootbirdfoot_be.service.CommentService;
import com.hanghae.dogfootbirdfoot_be.service.PostService;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MyPageController {

    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;

    @GetMapping("/mypage")
    public UserInfoDto findUser(@AuthenticationPrincipal UserDetailsImpl userDetails){
        if (userDetails == null){
            throw new BadCredentialsException("회원 정보를 찾을 수 없습니다.");
        }
        return userService.findUser(userDetails.getUsername());
    }

    //내가 작성한 게시물 가져오기.
    @GetMapping("/mypage/mypost")
    public Page<Post> getMyposts(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.getMypostLists(userDetails.getUser());
    }

//    //내가 작성한 댓글 가져오기.
//    @GetMapping("/mypage/mycomment")
//    public Page<Comment> getMyComments(@AuthenticationPrincipal UserDetailsImpl userDetails){
//        return commentService.getMyComments(userDetails.getUser());
//    }

//    @PostMapping("/mypage/userProfile")
//    public ModelAndView photoUpload()




}
