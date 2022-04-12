package com.hanghae.dogfootbirdfoot_be.dto.post;

import com.hanghae.dogfootbirdfoot_be.model.Comment;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostResponseDto {

    private List<Post> postList;

}
