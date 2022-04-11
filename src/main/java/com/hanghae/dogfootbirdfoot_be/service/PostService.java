package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
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
        if(category.isEmpty()){
            throw new IllegalArgumentException("카테고리를 정해주세요.");
        }

        List<Post> posts = postRepository.findByCategoryOrderByModifiedAtDesc(category);

        //여기서 부터 오류남 해결해야됨 null값 출력//변수 이름 잘못 씀//해결
        List<PostDto> postAll = new ArrayList<>();
        for (Post post:posts){
            PostDto postDto = new PostDto(post);
            postAll.add(postDto);
        }
        return postAll;
    }
}
