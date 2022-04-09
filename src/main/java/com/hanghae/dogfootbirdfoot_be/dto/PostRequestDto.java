package com.hanghae.dogfootbirdfoot_be.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String category;
    private String postTitle;
    private String postContents;
    private String nickname;
}
