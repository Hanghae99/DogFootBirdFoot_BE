package com.hanghae.dogfootbirdfoot_be.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
//프로필이랑 코멘트 갯수 받으려면 필요
public class PostDto {
    private Long postId;
    private String category;
    private String postTitle;
    private String postContents;
    private String userProfile;
    private String nickName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;
    private Long commentCount;

    public PostDto(Post result) {
        this.postId = result.getId();
        this.category = result.getCategory();
        this.postTitle = result.getPostTitle();
        this.postContents = result.getPostContents();
        this.createAt = result.getCreatedAt();
       //this.nickName = result.getUser.getNickName();
        //this.userProfile = result.getUser().getUserPrifile();
        //this.commentCount = result.getCommentList.size();

    }
}