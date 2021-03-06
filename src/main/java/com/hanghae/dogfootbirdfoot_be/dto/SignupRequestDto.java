package com.hanghae.dogfootbirdfoot_be.dto;

import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private Long userId;
    private String username;
    private String nickname;
    private String password;
    private String userProfile;
    private String email;

    public SignupRequestDto(UserDetailsImpl userDetails) {
        this.userId = userDetails.getUser().getUserId();
        this.username = userDetails.getUsername();
        this.nickname = userDetails.getUser().getNickname();
        this.userProfile = userDetails.getUser().getUserProfile();
        this.email = userDetails.getUser().getEmail();
    }
}
