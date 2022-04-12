package com.hanghae.dogfootbirdfoot_be.service;

import com.hanghae.dogfootbirdfoot_be.dto.CommentRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.CommentResponseDto;
import com.hanghae.dogfootbirdfoot_be.model.Comment;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.repository.CommentRepository;
import com.hanghae.dogfootbirdfoot_be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

//    public Page<Comment> getMyComments(User user) {
//        return commentRepository.findAllByUserOrderByCreatedAtDesc(user, PageRequest.of(0,5));
//    }

    //페이징 있어야 되는걸까? 아마도?

    // 댓글 작성
    @Transactional
    public CommentRequestDto createComment(CommentRequestDto commentRequestDto, Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new IllegalArgumentException("no data"));

        Comment comment = new Comment(commentRequestDto, post);
        commentRepository.save(comment);
        return commentRequestDto;
    }

    // 댓글 조회
    @Transactional
    public List<CommentResponseDto> getComment(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new IllegalArgumentException());

        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for(Comment comment : commentRepository.findAllByPostId(post)){
            String nickname = comment.getUserId().getUsername();
            String userProfile = comment.getUserId().getUserProfile();
            String comments = comment.getComments();
            LocalDateTime createdAt = comment.getCreatedAt();
            CommentResponseDto commentResponseDto = new CommentResponseDto(nickname, comments, userProfile, createdAt);
            commentResponseDtos.add(commentResponseDto);
        }
        return commentResponseDtos;
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

    // 댓글 수정

    @Transactional
    public void updateComment(Long commentId, CommentRequestDto commentRequestDto){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        comment.update(commentRequestDto);
    }

}