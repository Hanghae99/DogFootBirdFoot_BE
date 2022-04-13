package com.hanghae.dogfootbirdfoot_be.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hanghae.dogfootbirdfoot_be.model.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;

@Getter
public class CommentWriteResponseDto {
    private HashMap<String,String> statusMsg;
    private Long commentId;
    private Long userId;
    private String comments;
    private String nickname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;


    public CommentWriteResponseDto(HashMap<String,String> statusMsg, Comment comment){
        this.statusMsg=statusMsg;
        this.commentId = comment.getId();
        this.userId = comment.getUserId().getUserId();
        this.comments=comment.getComments();
        this.nickname=comment.getUserId().getNickname();
        this.createdAt = comment.getCreatedAt();

    }
}
