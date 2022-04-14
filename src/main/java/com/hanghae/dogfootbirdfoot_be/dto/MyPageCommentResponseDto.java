package com.hanghae.dogfootbirdfoot_be.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hanghae.dogfootbirdfoot_be.model.Comment;

import java.time.LocalDateTime;

public class MyPageCommentResponseDto {
    private Long userId;
    private Long postId;
    private Long commentId;
    private String comment;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    public MyPageCommentResponseDto(Comment comment){
        this.userId = comment.getUserId().getUserId();
        this.postId = comment.getPostId().getId();
        this.commentId = comment.getId();
        this.comment = comment.getComments();
        this.createdAt = comment.getCreatedAt();
    }
}
