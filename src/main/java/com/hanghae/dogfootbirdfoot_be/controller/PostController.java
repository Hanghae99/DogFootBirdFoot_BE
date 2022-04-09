package com.hanghae.dogfootbirdfoot_be.controller;


import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import com.hanghae.dogfootbirdfoot_be.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/api/post/write")
    public void createPost(@RequestParam PostRequestDto postRequestDto){

        postService.createPost(postRequestDto);
    }

}
