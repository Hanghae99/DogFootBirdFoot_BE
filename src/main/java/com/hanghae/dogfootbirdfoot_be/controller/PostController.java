package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostResponseDto;
import com.hanghae.dogfootbirdfoot_be.dto.SearchRequestDto;
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

    //바디로 못들어올 때 대비 파라미터로 받기

//    //검색한 것 조회
//    @GetMapping("/api/board/search")
//    public List<PostDto> search(@RequestParam String category, @RequestParam String searchWord){
//        SearchRequestDto searchRequestDto = new SearchRequestDto();
//        searchRequestDto.setCategory(category);
//        searchRequestDto.setSearchWord(searchWord);
//        //서비스로 보내서 해결하기
//        return searchService.search(searchRequestDto);
//    }

    @PostMapping("/api/post/write")
    public PostRequestDto createPost(@RequestBody PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);

    }

    @GetMapping("/api/post/detail/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId){
        return postService.getPost(postId);
    }



}