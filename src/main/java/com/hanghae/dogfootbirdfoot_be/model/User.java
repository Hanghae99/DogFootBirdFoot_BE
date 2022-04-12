package com.hanghae.dogfootbirdfoot_be.model;


import com.hanghae.dogfootbirdfoot_be.dto.SignupRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String userProfile;

    public User(SignupRequestDto signupRequestDto){
        this.username=signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
        this.email = signupRequestDto.getEmail();
        this.nickname = signupRequestDto.getNickname();

    }

    public User(String username, String passwordEncode, String email, String nickname) {
        this.username=username;
        this.password = passwordEncode;
        this.email = email;
        this.nickname = nickname;
    }
    public void updateImgUrl ( String newImgUrl ) {
        this.userProfile = newImgUrl;
    }
}
