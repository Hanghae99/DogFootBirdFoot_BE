package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.dto.SignupRequestDto;
import com.hanghae.dogfootbirdfoot_be.dto.SignupResponseDto;
import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;


    @PostMapping("/api/userChk")
    public SignupResponseDto getHome(@AuthenticationPrincipal UserDetailsImpl userDetails){
        HashMap<String,String> hashMap = new HashMap<>();
        if(userDetails!=null){
            hashMap.put("result","true");
            hashMap.put("msg" , "로그인한 사용자입니다.");
            return new SignupResponseDto(userDetails,hashMap);
        }else{
            hashMap.put("result","false");
            hashMap.put("msg" , "로그인이 필요한 사용자입니다.");
            return new SignupResponseDto(hashMap);
        }

}
}
