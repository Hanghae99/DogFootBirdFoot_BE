package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.dto.CommentRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.CommentResponseDto;
import com.hanghae.dogfootbirdfoot_be.repository.CommentRepositroy;
import com.hanghae.dogfootbirdfoot_be.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepositroy commentRepositroy;

    // 댓글 작성
    @PostMapping("/api/post/detail/{postId}/comment")
    public void createComment(@RequestParam CommentRequestDto commentRequestDto, @PathVariable Long postId){
        commentService.createComment(commentRequestDto, postId);
    }


    //댓글 조회
    @GetMapping("/api/post/detail/{postId}/comment")
    public List<CommentResponseDto> getComment(@PathVariable Long postId) {
        System.out.println(postId);
        return commentService.getComment(postId);
    }

    // 댓글 삭제
    //22.4.13 댓글 삭제 수정
    @DeleteMapping("/api/post/detail/comment/{commentId}")
    public HashMap<String, String> deleteComment(@PathVariable Long commentId, @RequestParam Long userId){
        return commentService.deleteComment(commentId, userId);
    }

    //댓글 수정
    //22.4.13 댓글 수정 수정
    @PutMapping("/api/post/detail/comment/{commentId}")
    public HashMap<String, String> updateComment(@PathVariable Long commentId, @RequestParam CommentRequestDto commentRequestDto){
        return commentService.updateComment(commentId, commentRequestDto);
    }
}
