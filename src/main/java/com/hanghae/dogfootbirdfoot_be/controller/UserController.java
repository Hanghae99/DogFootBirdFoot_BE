package com.hanghae.dogfootbirdfoot_be.controller;


import com.hanghae.dogfootbirdfoot_be.dto.SignupRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    // 회원가입
    @PostMapping("/api/user/signup")
    public User userSignup(@RequestBody SignupRequestDto signupRequestDto){
       return userService.userSignup(signupRequestDto);
    }

    @GetMapping("/api/user/dupliChk")
    public HashMap userDupliChk(@RequestBody SignupRequestDto signupRequestDto){
        return  userService.userDupliChk(signupRequestDto.getUsername());
    }


}
