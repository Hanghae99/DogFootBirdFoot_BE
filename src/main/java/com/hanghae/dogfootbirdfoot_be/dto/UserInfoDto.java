package com.hanghae.dogfootbirdfoot_be.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

    private String username;
    private String email;
    private String nickName;


    public UserInfoDto(String username,String  email,String nickName){
        this.username =username;
        this.email=email;
        this.nickName=nickName;


    }
}
