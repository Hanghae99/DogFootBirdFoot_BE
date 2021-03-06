package com.hanghae.dogfootbirdfoot_be.service;


import com.hanghae.dogfootbirdfoot_be.dto.*;
import com.hanghae.dogfootbirdfoot_be.model.Comment;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.repository.CommentRepositroy;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import com.hanghae.dogfootbirdfoot_be.validator.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.hanghae.dogfootbirdfoot_be.validator.ServiceValidator.OptionalSaveChk;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepositroy commentRepositroy;
    private final PostRepository postRepository;


    // 댓글 작성
    @Transactional
    public CommentWriteResponseDto createComment(CommentRequestDto commentRequestDto, Long postId, User user){
        String comment = commentRequestDto.getComment();
        ServiceValidator.validateComment(comment);
        Post post = postRepository.findById(postId)
                .orElseThrow(
                () -> new IllegalArgumentException("no data"));
        Comment comments = new Comment(commentRequestDto, post,user);
        Comment saveComment = commentRepositroy.save(comments);
        HashMap<String,String> statusComment = OptionalSaveChk(saveComment);
        return new CommentWriteResponseDto(statusComment,saveComment);
    }

    // 댓글 조회
    @Transactional
    public List<CommentResponseDto> getComment(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new IllegalArgumentException());

        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
            for(Comment comment :commentRepositroy.findAllByPostId(post)){
                String nickname = comment.getUserId().getUsername();
                String userProfile = comment.getUserId().getUserProfile();
                String comments = comment.getComments();
                Long commentId = comment.getId();
                LocalDateTime createdAt = comment.getCreatedAt();
                CommentResponseDto commentResponseDto = new CommentResponseDto(nickname,commentId, comments, userProfile, createdAt);
                commentResponseDtos.add(commentResponseDto);
            }
            return commentResponseDtos;
    }

    // 댓글 삭제
    //22.4.13 댓글 삭제 수정
    @Transactional
    public HashMap<String, String> deleteComment(Long commentId, Long userId){
        HashMap<String, String> hashMap = new HashMap<>();
       Comment comment = commentRepositroy.findById(commentId).orElseThrow(
               ()->new IllegalArgumentException("댓글이 존재하지 않습니다.")
       );
       if(comment.getUserId().getUserId().equals(userId)){
           commentRepositroy.deleteById(commentId);
           hashMap.put("result", "true");
           hashMap.put("msg", "댓글이 삭제되었습니다.");
           return hashMap;
       }else {
           hashMap.put("result", "false");
           hashMap.put("msg", "댓글 삭제에 실패하였습니다.");
           return hashMap;
       }
    }

    // 댓글 수정
    // 22.4.13 댓글 수정 수정
    @Transactional
    public HashMap<String, String> updateComment(Long commentId, CommentRequestDto commentRequestDto){
        HashMap<String, String> hashMap = new HashMap<>();
        Comment comments = commentRepositroy.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        String comment = commentRequestDto.getComment();
        ServiceValidator.validateComment(comment);
        if(comments.getUserId().equals(commentRequestDto.getUserId())){
            comments.update(commentRequestDto);
            hashMap.put("result", "true");
            hashMap.put("msg", "댓글이 수정되었습니다.");
            return hashMap;
        }else {
            hashMap.put("result", "false");
            hashMap.put("msg", "댓글 수정에 실패하였습니다.");
            return hashMap;
        }
    }

    //마이페이지 내 댓글 조회 2022-04-14
    public List<MyPageCommentResponseDto> getMycommentLists(Long userId) {
        // 전체 내 댓글 조회
        List<Comment> list = commentRepositroy.findAllByUserId_UserId(userId);
        List<MyPageCommentResponseDto> responseDto = new ArrayList<>();

        for (Comment one : list){
            MyPageCommentResponseDto myPageCommentResponseDto = new MyPageCommentResponseDto(one);
            responseDto.add(myPageCommentResponseDto);
        }
        return responseDto;
    }

}
