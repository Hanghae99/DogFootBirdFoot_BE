package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostResponseDto;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.repository.CommentRepositroy;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import com.hanghae.dogfootbirdfoot_be.validator.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    // 게시물 전체 조회
    @Transactional
    public List<PostDto> getPosts(String category){

        ServiceValidator.validatePost(category);

        List<Post> posts = postRepository.findByCategoryOrderByModifiedAtDesc(category);


        List<PostDto> postAll = new ArrayList<>();
        for (Post post:posts){
            PostDto postDto = new PostDto(post);
            postAll.add(postDto);
        }
        return postAll;
    }
    // 게시글 작성
    @Transactional
    public PostRequestDto createPost(PostRequestDto postRequestDto, User user){
//        Long userId = userDetails.getId;
        Post post = new Post(postRequestDto,user);
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

    //마이페이지
    public Page<Post> getMypostLists(User user) {
        return postRepository.findAllByUserOrderByCreatedAtDesc(user, PageRequest.of(0,5));
    }
}
