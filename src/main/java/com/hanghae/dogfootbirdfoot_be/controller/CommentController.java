package com.hanghae.dogfootbirdfoot_be.controller;


import com.hanghae.dogfootbirdfoot_be.dto.CommentRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.CommentResponseDto;
import com.hanghae.dogfootbirdfoot_be.repository.CommentRepository;
import com.hanghae.dogfootbirdfoot_be.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    // 댓글 작성
    @PostMapping("/api/post/detail/{postId}/comment")
    public void createComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long postId){
        commentService.createComment(commentRequestDto, postId);
    }

    //댓글 조회
    @GetMapping("/api/post/detail/{postId}/comment")
    public List<CommentResponseDto> getComment(@PathVariable Long postId){
        System.out.println(postId);
        return commentService.getComment(postId);
    }

    // 댓글 삭제
    @DeleteMapping("/api/post/detail/comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

    //댓글 수정
    @PutMapping("/api/post/detail/comment/{commentId}")
    public void updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto){
        commentService.updateComment(commentId, commentRequestDto);
    }
}