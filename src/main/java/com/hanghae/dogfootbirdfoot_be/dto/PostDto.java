package com.hanghae.dogfootbirdfoot_be.dto;

import com.hanghae.dogfootbirdfoot_be.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PostDto {
    private Long postId;
    private String category;
    private String postTitle;
    private String postContents;
    private String userProfile;
    private String nickName;
    private LocalDateTime createAt;
   // private Long commentCount;

    public PostDto(Post result) {
        this.postId = result.getId();
        this.category = result.getCategory();
        this.postTitle = result.getPostTitle();
        this.postContents = result.getPostContents();
        this.createAt = result.getCreatedAt();
        this.nickName = result.getNickName();
        //this.userProfile = getUser().getUserPrifile();
        //this.commentCount = getComment.size();
    }
}