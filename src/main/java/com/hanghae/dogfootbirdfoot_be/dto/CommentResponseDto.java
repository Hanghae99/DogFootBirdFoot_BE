package com.hanghae.dogfootbirdfoot_be.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private  String nickname;
    private String comments;
    private String userProfile;
    private LocalDateTime createdAt;

    public CommentResponseDto(String nickname, String comments, String userProfile, LocalDateTime createdAt){
        this.nickname = nickname;
        this.comments = comments;
        this.userProfile = userProfile;
        this.createdAt = createdAt;
    }
}
