package com.hanghae.dogfootbirdfoot_be.dto;


import com.hanghae.dogfootbirdfoot_be.model.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long postId;
    private String category;
    private String postTitle;
    private String postContents;
    private String nickname;
    private int commentCount;
    private int likeCount;
    private LocalDateTime createdAt;

    public PostResponseDto (Post post){
        this.postId = post.getId();
        this.category = post.getCategory();
        this.postTitle = post.getPostTitle();
        this.postContents = post.getPostContents();

    }
}
