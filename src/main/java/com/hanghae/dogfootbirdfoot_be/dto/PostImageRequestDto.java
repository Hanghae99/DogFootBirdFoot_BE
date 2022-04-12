package com.hanghae.dogfootbirdfoot_be.dto;

import lombok.Getter;

@Getter
public class PostImageRequestDto {
    private String imageUrl;

    public PostImageRequestDto(String uploadImageUrl){
        this.imageUrl = uploadImageUrl;
    }
}
