package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import com.hanghae.dogfootbirdfoot_be.validator.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service


public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public List<PostDto> getPost(String category){

        ServiceValidator.validatePost(category);

        List<Post> posts = postRepository.findByCategoryOrderByModifiedAtDesc(category);


        List<PostDto> postAll = new ArrayList<>();
        for (Post post:posts){
            PostDto postDto = new PostDto(post);
            postAll.add(postDto);
        }
        return postAll;
    }

}
