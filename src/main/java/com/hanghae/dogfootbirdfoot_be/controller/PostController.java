package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.dto.SearchRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import com.hanghae.dogfootbirdfoot_be.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final SearchService searchService;

    //게시글 조회
    @GetMapping("/api/board/{category}")
    public List<PostDto> getPosts(@PathVariable("category") String category) {
        if(category.isEmpty()){
            throw new IllegalArgumentException("카테고리를 정해주세요.");
        }
        List<Post> posts = postRepository.findByCategoryOrderByModifiedAtDesc(category);

        List<PostDto> postAll = new ArrayList<>();
        for (Post post:posts){
            PostDto postDto = new PostDto(post);
            postAll.add(postDto);
        }
        return postAll;
    }

    //검색한 것 조회
    @GetMapping("/api/board/search")
    public List<PostDto> search(@RequestBody SearchRequestDto searchRequestDto){
        //서비스로 보내서 해결하기
        return searchService.search(searchRequestDto);
    }

}
