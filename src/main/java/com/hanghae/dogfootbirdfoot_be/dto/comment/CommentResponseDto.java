package com.hanghae.dogfootbirdfoot_be.dto.comment;

import com.hanghae.dogfootbirdfoot_be.model.Comment;
import lombok.Getter;

import java.util.List;

@Getter
public class CommentResponseDto {

    private List<Comment> commentList;
}
