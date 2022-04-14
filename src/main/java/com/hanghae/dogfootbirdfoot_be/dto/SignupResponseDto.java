package com.hanghae.dogfootbirdfoot_be.dto;

import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;

import java.util.HashMap;

public class SignupResponseDto {
    private HashMap<String,String> result;
    private Long userId;
    private String username;
    private String nickname;
    private String userProfile;
    private String email;

    public SignupResponseDto(UserDetailsImpl userDetails, HashMap<String,String> result) {
        this.result=result;
        this.userId = userDetails.getUser().getUserId();
        this.username = userDetails.getUsername();
        this.nickname = userDetails.getUser().getNickname();
        this.userProfile = userDetails.getUser().getUserProfile();
        this.email = userDetails.getUser().getEmail();
    }

    public SignupResponseDto(HashMap<String,String> result){
        this.result=result;
    }
}
