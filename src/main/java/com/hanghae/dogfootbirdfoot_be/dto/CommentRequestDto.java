package com.hanghae.dogfootbirdfoot_be.dto;


import lombok.Getter;

//22.4.13 CommentRequestDto 수정
@Getter
public class CommentRequestDto {
    private String comment;
    private Long userId;
}
