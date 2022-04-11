package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostResponseDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    // 게시글 작성
    @Transactional
    public PostRequestDto createPost(PostRequestDto postRequestDto){
//        Long userId = userDetails.getId;
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return postRequestDto;
    }


    //게시글 상세 조회
    @Transactional
    public PostResponseDto getPost(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new IllegalArgumentException()
        );
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

}
