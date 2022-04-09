package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostRequestDto createPost(PostRequestDto postRequestDto){
        String category = postRequestDto.getCategory();
        String postTitle = postRequestDto.getPostTitle();
        String postContents = postRequestDto.getPostContents();
        String nickname = postRequestDto.getNickname();

        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return postRequestDto;
    }
}
