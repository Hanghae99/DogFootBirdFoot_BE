package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.dto.MyPageCommentResponseDto;
import com.hanghae.dogfootbirdfoot_be.dto.MyPagePostResponseDto;
import com.hanghae.dogfootbirdfoot_be.model.Comment;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import com.hanghae.dogfootbirdfoot_be.service.CommentService;
import com.hanghae.dogfootbirdfoot_be.service.PostService;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MyPageController {

    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;

    @GetMapping("/mypage")
    public HashMap findUser(@AuthenticationPrincipal  UserDetailsImpl userDetails){
        if (userDetails == null){
            throw new BadCredentialsException("회원 정보를 찾을 수 없습니다.");
        }
        return userService.findUser(userDetails.getUsername());
    }

    //내가 작성한 게시물 가져오기.
    @GetMapping("/mypage/mypost")
    public List<MyPagePostResponseDto> getMypost(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("내가 작성한 게시물에서 유저아이디 : "+ userDetails.getUser().getUserId());

        return postService.getMypostLists(userDetails.getUser().getUserId());
    }
    //내 댓글 조회 2022-04-13
    @GetMapping("/mypage/mycomment")
    public List<MyPageCommentResponseDto> getMycomment(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("내가 작성한 게시물에서 유저아이디 : "+ userDetails.getUser().getUserId());

        return commentService.getMycommentLists(userDetails.getUser().getUserId());
    }





}
