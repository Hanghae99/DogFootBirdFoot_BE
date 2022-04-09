package com.hanghae.dogfootbirdfoot_be.dto;

import com.hanghae.dogfootbirdfoot_be.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PostDto {
    private Long postID;
    private String category;
    private String title;
    private String postContents;
    private String userProfile;
    private String nickName;
    private String createAt;
    private Long commentCount;

    public PostDto(Post result) {
        this.postID = getPostID();
        this.category = getCategory();
        this.title = getTitle();
        this.createAt = getCreateAt();
        this.nickName = getNickName();
        this.createAt = getCreateAt();
        //this.userProfile = getUser().getUserPrifile();
        //this.commentCount = getComment.size();
    }
}