package com.hanghae.dogfootbirdfoot_be.dto;

import lombok.Getter;


//22.4.13 게시글 삭제용 dto 생성
@Getter
public class PostDeleteRequestDto {
    private Long userId;
    private Long postId;
}
