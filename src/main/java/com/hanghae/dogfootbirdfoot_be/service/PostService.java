package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.PostDeleteRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.PostResponseDto;
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


    //22.4.13 게시글 삭제 생성
    @Transactional
    public HashMap<String, String> deletePost(PostDeleteRequestDto postDeleteRequestDto){
        HashMap<String, String> hashMap = new HashMap<>();
        Post post = postRepository.findById(postDeleteRequestDto.getPostId()).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        if(post.getUser().getUserId().equals(postDeleteRequestDto.getUserId())){
            postRepository.deleteById(postDeleteRequestDto.getPostId());
            hashMap.put("result", "true");
            hashMap.put("msg", "게시글이 삭제되었습니다.");
            return hashMap;
        }else {
            hashMap.put("result", "false");
            hashMap.put("msg", "게시글 삭제에 실패하였습니다");
            return hashMap;
        }

    }


}
