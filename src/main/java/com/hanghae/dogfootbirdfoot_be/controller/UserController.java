package com.hanghae.dogfootbirdfoot_be.controller;


import com.hanghae.dogfootbirdfoot_be.dto.IdDuplicate;
import com.hanghae.dogfootbirdfoot_be.dto.SignupRequestDto;
import com.hanghae.dogfootbirdfoot_be.model.User;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println( "회원가입" +signupRequestDto.getUsername());
       return userService.userSignup(signupRequestDto);
    }

    @PostMapping ("/api/user/dupliChk")
    public String userDupliChk(
            @RequestBody IdDuplicate idDuplicate
           // @RequestParam("username") String username
           // @PathVariable String param
    ){
        //System.out.println("RequestParam " + username);
        System.out.println("아이디 중복 확인 "+idDuplicate.getUsername());
        if(userService.userDupliChk(idDuplicate.getUsername()).get("result").equals("true")){
            return "true";
        }else{
            return "false";
        }


    }


}
