package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.*;
import com.hanghae.dogfootbirdfoot_be.model.Comment;
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
import java.util.HashMap;
import java.util.List;

import static com.hanghae.dogfootbirdfoot_be.validator.ServiceValidator.postDeleteAuthChk;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepositroy commentRepository;


    // 게시물 전체 조회
    @Transactional
    public List<PostDto> getPosts(String category){

        ServiceValidator.validatePost(category);

        List<Post> posts = postRepository.findByCategoryOrderByModifiedAtDesc(category);


        List<PostDto> postAll = new ArrayList<>();
        //22.4.13 코멘트 수정
        for (Post post:posts){
            List<Comment> commentNum = commentRepository.findAllByPostId(post);
            int commentCount = commentNum.size();
            PostDto postDto = new PostDto(post,commentCount);

            postAll.add(postDto);
        }
        return postAll;
    }
    // 게시글 작성 22.4.13 게시글 유효성검사추가
    @Transactional
    public PostRequestDto createPost(PostRequestDto postRequestDto, User user){
//        Long userId = userDetails.getId;

        String postContents = postRequestDto.getPostContents();
        ServiceValidator.validatePostWrite(postContents);
        Post post = new Post(postRequestDto, user);
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


    //22.4.13 게시글 삭제
    @Transactional
    public HashMap<String, String> deletePost(Long postId,User user){
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        // 게시글을 작성한 사람
        Long writeUser = post.getUser().getUserId();
        // 로그인한 사람
        Long loginUser = user.getUserId();
        System.out.println("게시글 작성한 사람 : " + writeUser);
        System.out.println("로그인한 사람 : " + loginUser);
        HashMap<String,String> hashMap = postDeleteAuthChk(writeUser,loginUser);
        if(hashMap.get("result").equals("true")) {
            postRepository.deleteById(postId);

        }
       return hashMap;

    }
    //마이페이지 내 게시물 조회 2022-04-14
    public List<MyPagePostResponseDto> getMypostLists(Long userId) {
        // 전체 내 게시물 조회
        List<Post> list =  postRepository.findAllByUser_UserId(userId);
        List<MyPagePostResponseDto> responseDto = new ArrayList<>();

        for(Post one : list){
            MyPagePostResponseDto myPagePostResponseDto = new MyPagePostResponseDto(one);
            responseDto.add(myPagePostResponseDto);
        }
        return responseDto;

    }


}
