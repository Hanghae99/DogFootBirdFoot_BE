package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;


    @PostMapping("/api/home")
    public String getHome(@AuthenticationPrincipal UserDetailsImpl userDetails){
        if(userDetails!=null){
        return userDetails.getUsername();
    }
        return "로그인 안됨";
}
}
