package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.SearchRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import com.hanghae.dogfootbirdfoot_be.service.PostService;
import com.hanghae.dogfootbirdfoot_be.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final SearchService searchService;
    private final PostService postService;


//    //게시글 생성
//    @PostMapping("/api/board")
//    public Post createBlog(@RequestBody PostRequestDto postRequestDto){
//        String category = postRequestDto.getCategory();
//        String postTitle = postRequestDto.getPostTitle();
//        String postContents = postRequestDto.getPostContents();
//        //String nickName = postRequestDto.getNickName();
//
//        Post post = new Post(category, postTitle,postContents);
//        postRepository.save(post);
//        return post;
//
//    }
//
    //게시글 조회
    @GetMapping("/api/board/{category}")
    public List<PostDto> getPosts(@PathVariable("category") String category) {

        return postService.getPost(category);
    }

    //검색한 것 조회
    @GetMapping("/api/board/search")
    public List<PostDto> search(@RequestBody SearchRequestDto searchRequestDto){

        //서비스로 보내서 해결하기
        return searchService.search(searchRequestDto);
    }

}
