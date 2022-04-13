package com.hanghae.dogfootbirdfoot_be.controller;


import com.hanghae.dogfootbirdfoot_be.dto.*;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import com.hanghae.dogfootbirdfoot_be.service.PostService;
import com.hanghae.dogfootbirdfoot_be.service.S3Uploader;
import com.hanghae.dogfootbirdfoot_be.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService postService;
    private final S3Uploader s3Uploader;
    private final SearchService searchService;

    // 게시물 작성
    @PostMapping("/api/post/write")
    public PostRequestDto  createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return postService.createPost(postRequestDto, user);

    }

    // 게시물 상세페이지
    @GetMapping("/api/post/detail/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId){
       return postService.getPost(postId);
    }

    //게시글 조회
    @GetMapping("/api/board/{category}")
    public List<PostDto> getPosts(@PathVariable("category") String category) {

        return postService.getPosts(category);
    }

    //검색한 것 조회
    @GetMapping("/api/board/search")
    public List<PostDto> search(@RequestBody SearchRequestDto searchRequestDto){

        //서비스로 보내서 해결하기
        return searchService.search(searchRequestDto);
    }

    // 게시물 삭제 22.4.13 작성
    @DeleteMapping("/api/post/delete")
    public HashMap<String, String> deletePost(@RequestBody PostDeleteRequestDto postDeleteRequestDto){
        return postService.deletePost(postDeleteRequestDto);
    }
}
