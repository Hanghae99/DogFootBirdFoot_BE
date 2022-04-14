package com.hanghae.dogfootbirdfoot_be.dto;

import lombok.Getter;

@Getter
//수정
public class UserImageRequestDto {
    private String imageUrl;
    public UserImageRequestDto(String uploadImageUrl){
        this.imageUrl = uploadImageUrl;
    }
}
