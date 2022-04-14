package com.hanghae.dogfootbirdfoot_be.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MyPagePostResponseDto {
    private Long userId;
    private Long postId;
    private String postTitle;
    private String category;
    private String postContents;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    public MyPagePostResponseDto(Post post){
        this.userId=post.getUser().getUserId();
        this.postId=post.getId();
        this.postTitle=post.getPostTitle();
        this.createdAt = post.getCreatedAt();
        this.category= post.getCategory();
        this.postContents=getPostContents();
    }






}
